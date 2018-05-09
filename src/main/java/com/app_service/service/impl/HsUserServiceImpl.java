package com.app_service.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app_service.common.Response;
import com.app_service.common.SessionManager;
import com.app_service.common.VerifyCodeManager;
import com.app_service.dao.configuration.ResourceConfig;
import com.app_service.dao.mapper.hs_user.HUserMapper;
import com.app_service.dao.mapper.hs_user.SUserActiveMapper;
import com.app_service.dao.mapper.hs_user.SUserEmailMapper;
import com.app_service.dao.mapper.hs_user.SUserFeedbackMapper;
import com.app_service.dao.mapper.hs_user.SUserGenderMapper;
import com.app_service.dao.mapper.hs_user.SUserNameMapper;
import com.app_service.dao.mapper.hs_user.SUserPasswordMapper;
import com.app_service.dao.mapper.hs_user.SUserProfileMapper;
import com.app_service.dao.mapper.hs_user.TUserPageMapper;
import com.app_service.entity.enums.StatusEnum;
import com.app_service.entity.hs_user.HUser;
import com.app_service.entity.hs_user.SUserActive;
import com.app_service.entity.hs_user.SUserEmail;
import com.app_service.entity.hs_user.SUserFeedback;
import com.app_service.entity.hs_user.SUserFeedbackSummary;
import com.app_service.entity.hs_user.SUserGender;
import com.app_service.entity.hs_user.SUserName;
import com.app_service.entity.hs_user.SUserPassword;
import com.app_service.entity.hs_user.SUserProfile;
import com.app_service.entity.hs_user.TUserPage;
import com.app_service.entity.hs_user.TUserSummary;
import com.app_service.service.IHsUserService;
import com.app_service.util.CommonUtil;
import com.app_service.util.FileUtil;
import com.app_service.util.HsUserUtil;
import com.app_service.util.VerifyCodeUtil;

@Service
public class HsUserServiceImpl implements IHsUserService {
    @Autowired
    TUserPageMapper tUserPageMapper;

    @Autowired
    HUserMapper hUserMapper;

    @Autowired
    SUserPasswordMapper sUserPasswordMapper;

    @Autowired
    SUserActiveMapper sUserActiveMapper;

    @Autowired
    SUserFeedbackMapper sUserFeedbackMapper;

    @Autowired
    SUserEmailMapper sUserEmailMapper;

    @Autowired
    SUserNameMapper sUserNameMapper;

    @Autowired
    SUserGenderMapper sUserGenderMapper;

    @Autowired
    SUserProfileMapper sUserProfileMapper;

    @Autowired
    private ResourceConfig resourceConfig;

    @Override
    public List<TUserSummary> getTUserSummary(Map<String, Object> paramMap) {
        List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);
        List<TUserSummary> userSummaryList = HsUserUtil.userPage2UserSummary(userPageList);

        return userSummaryList;
    }

    @Override
    @Transactional
    public int regist(TUserSummary tUserSummary) {
        String verifyCode = VerifyCodeManager.getVerifyCodeByPhoneNum(String.valueOf(tUserSummary.gethUserPhoneNr()));
        if (null == verifyCode) {
            return Response.ERROR;
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("hUserPhoneNr", tUserSummary.gethUserPhoneNr());
        List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);
        if (null != userPageList && 0 < userPageList.size()) {
            return Response.ERROR;
        }

        Date timestamp = new Date();
        tUserSummary.setCreateTs(timestamp);
        tUserSummary.setUpdateTs(timestamp);

        // HUser
        HUser user = HsUserUtil.userSummary2User(tUserSummary);
        hUserMapper.insertSelective(user);
        long userId = hUserMapper.getMaxHUserId();

        tUserSummary.sethUserId(userId);
        tUserSummary.setsUserPasswordStr(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()));

        // SUserPassword
        SUserPassword sUserPassword = HsUserUtil.userSummary2UserPassword(tUserSummary);
        sUserPasswordMapper.insertSelective(sUserPassword);

        // SUserActive
        SUserActive sUserActive = HsUserUtil.userSummary2UserActive(tUserSummary);
        sUserActiveMapper.insertSelective(sUserActive);

        // TUserPage
        TUserPage userPage = HsUserUtil.userSummary2UserPage(tUserSummary);
        tUserPageMapper.insertSelective(userPage);

        return Response.SUCCESS;
    }

    @Override
    public String login(TUserSummary tUserSummary) {
        if (null == tUserSummary || null == tUserSummary.gethUserPhoneNr()
                || null == tUserSummary.getsUserPasswordStr()) {
            return null;
        }

        TUserSummary tUserSummaryResult = selectByhUserPhoneNr(tUserSummary.gethUserPhoneNr());

        if (null == tUserSummaryResult || null == tUserSummaryResult.getsUserPasswordStr()) {
            return null;
        }

        if (!tUserSummaryResult.getsUserPasswordStr()
                .equals(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()))) {
            return null;
        }

        String sessionCode = SessionManager.newSession(tUserSummaryResult);

        return sessionCode;
    }

    @Override
    public int logout(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    @Transactional
    public int reset(TUserSummary tUserSummary) {
        String verifyCode = VerifyCodeManager.getVerifyCodeByPhoneNum(String.valueOf(tUserSummary.gethUserPhoneNr()));
        if (null == verifyCode) {
            return Response.ERROR;
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("hUserPhoneNr", tUserSummary.gethUserPhoneNr());
        List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);
        if (null == userPageList || 0 == userPageList.size()) {
            return Response.ERROR;
        }

        Date timestamp = new Date();

        TUserSummary tUserSummaryResult = HsUserUtil.userPage2UserSummary(userPageList).get(0);
        tUserSummaryResult.setUpdateTs(timestamp);

        // HUser
        HUser user = HsUserUtil.userSummary2User(tUserSummaryResult);
        tUserSummaryResult.sethUserId(user.gethUserId());

        // SUserPassword
        tUserSummaryResult.setsUserPasswordStr(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()));
        SUserPassword sUserPassword = HsUserUtil.userSummary2UserPassword(tUserSummaryResult);
        sUserPasswordMapper.updateByPrimaryKeySelective(sUserPassword);

        // TUserPage
        TUserPage userPage = HsUserUtil.userSummary2UserPage(tUserSummaryResult);
        tUserPageMapper.updateByPrimaryKeySelective(userPage);
        return Response.SUCCESS;
    }

    @Override
    public String getVerifyCode(String hUserPhoneNr) {
        String verifyCode = VerifyCodeManager.generateVerifyCode(hUserPhoneNr);
        // VerifyCodeUtil.sendPhoneVerifyCode(verifyCode, hUserPhoneNr);
        VerifyCodeUtil.sendPhoneVerifyCode("目标人物出现!!!", hUserPhoneNr);

        return verifyCode;
    }

    @Override
    public TUserSummary selectByhUserPhoneNr(Long hUserPhoneNr) {
        return tUserPageMapper.selectByhUserPhoneNr(hUserPhoneNr);
    }

    @Override
    public List<SUserFeedbackSummary> getSUserFeedbackSummaryByCondition(Map<String, Object> paramMap) {
        return sUserFeedbackMapper.getSUserFeedbackSummaryByCondition(paramMap);
    }

    @Override
    public int getSUserFeedbackSummaryByConditionCount(Map<String, Object> paramMap) {
        return sUserFeedbackMapper.getSUserFeedbackSummaryByConditionCount(paramMap);
    }

    @Override
    @Transactional
    public int addSUserFeedbackSummary(SUserFeedbackSummary sUserFeedbackSummary) {
        Long hUserPhoneNr = sUserFeedbackSummary.gethUserPhoneNr();
        if (null == hUserPhoneNr) {
            return Response.ERROR;
        }

        HUser hUser = hUserMapper.selectByPhoneNr(hUserPhoneNr);
        if (null == hUser) {
            return Response.ERROR;
        }

        Date timestamp = new Date();
        sUserFeedbackSummary.setCreateTs(timestamp);
        sUserFeedbackSummary.setUpdateTs(timestamp);
        sUserFeedbackSummary.sethUserId(hUser.gethUserId());

        SUserFeedback sUserFeedback = HsUserUtil.userFeedbackSummanry2UserFeedback(sUserFeedbackSummary);
        return sUserFeedbackMapper.insertSelective(sUserFeedback);
    }

    @Override
    @Transactional
    public int addTUserSummary(TUserSummary tUserSummary) {
        Date timestamp = new Date();
        tUserSummary.setCreateTs(timestamp);
        tUserSummary.setUpdateTs(timestamp);

        // HUser
        HUser hUser = HsUserUtil.userSummary2User(tUserSummary);
        hUserMapper.insertSelective(hUser);
        long hUserId = hUserMapper.getMaxHUserId();
        tUserSummary.sethUserId(hUserId);

        // SUserActive
        SUserActive sUserActive = HsUserUtil.userSummary2UserActive(tUserSummary);
        sUserActiveMapper.insertSelective(sUserActive);

        // SUserEmail
        SUserEmail sUserEmail = HsUserUtil.userSummary2UserEmail(tUserSummary);
        sUserEmailMapper.insertSelective(sUserEmail);

        // SUserGender
        SUserGender sUserGender = HsUserUtil.userSummary2UserGender(tUserSummary);
        sUserGenderMapper.insertSelective(sUserGender);

        // SUserName
        SUserName sUserName = HsUserUtil.userSummary2UserName(tUserSummary);
        sUserNameMapper.insertSelective(sUserName);

        // SUserPassword
        SUserPassword sUserPassword = HsUserUtil.userSummary2UserPassword(tUserSummary);
        sUserPasswordMapper.insertSelective(sUserPassword);

        // SUserProfile
        SUserProfile sUserProfile = HsUserUtil.userSummary2UserProfile(tUserSummary);
        sUserProfileMapper.insertSelective(sUserProfile);

        // TUserPage
        TUserPage tUserPage = HsUserUtil.userSummary2UserPage(tUserSummary);
        tUserPageMapper.insertSelective(tUserPage);

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int editTUserSummary(TUserSummary tUserSummary) {
        Date timestamp = new Date();
        tUserSummary.setUpdateTs(timestamp);
        
        // find HUser by phone number
        HUser hUserInDatabase = hUserMapper.selectByPhoneNr(tUserSummary.gethUserPhoneNr());
        if(null==hUserInDatabase) {
            return Response.ERROR;
        }
        tUserSummary.sethUserId(hUserInDatabase.gethUserId());

        // HUser
        HUser hUser = HsUserUtil.userSummary2User(tUserSummary);
        hUserMapper.updateByPrimaryKeySelective(hUser);

        // SUserActive
        SUserActive sUserActive = HsUserUtil.userSummary2UserActive(tUserSummary);
        sUserActiveMapper.updateByPrimaryKeySelective(sUserActive);

        // SUserEmail
        SUserEmail sUserEmail = HsUserUtil.userSummary2UserEmail(tUserSummary);
        sUserEmailMapper.updateByPrimaryKeySelective(sUserEmail);

        // SUserGender
        SUserGender sUserGender = HsUserUtil.userSummary2UserGender(tUserSummary);
        sUserGenderMapper.updateByPrimaryKeySelective(sUserGender);

        // SUserName
        SUserName sUserName = HsUserUtil.userSummary2UserName(tUserSummary);
        sUserNameMapper.updateByPrimaryKeySelective(sUserName);

        // SUserPassword
        SUserPassword sUserPassword = HsUserUtil.userSummary2UserPassword(tUserSummary);
        sUserPasswordMapper.updateByPrimaryKeySelective(sUserPassword);

        // SUserProfile
        SUserProfile sUserProfile = HsUserUtil.userSummary2UserProfile(tUserSummary);
        sUserProfileMapper.updateByPrimaryKeySelective(sUserProfile);

        // TUserPage
        TUserPage tUserPage = HsUserUtil.userSummary2UserPage(tUserSummary);
        tUserPageMapper.updateByPrimaryKeySelective(tUserPage);

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int deleteTUserSummary(TUserSummary tUserSummary) {
        Date timestamp = new Date();
        tUserSummary.setUpdateTs(timestamp);
        tUserSummary.setsUserActiveInd(StatusEnum.Unactive.getCode());

        // SUserActive
        SUserActive sUserActive = HsUserUtil.userSummary2UserActive(tUserSummary);
        sUserActiveMapper.updateByPrimaryKeySelective(sUserActive);

        // TUserPage
        TUserPage tUserPage = HsUserUtil.userSummary2UserPage(tUserSummary);
        tUserPageMapper.updateByPrimaryKeySelective(tUserPage);

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public String uploadFileBase64(String fileBase64, String fileName, String token, Long hUserPhoneNr) {
        TUserSummary user = tUserPageMapper.selectByhUserPhoneNr(hUserPhoneNr);

        if (user != null) {
            String destPath = resourceConfig.getPrefix() + resourceConfig.getPortrait() + hUserPhoneNr + ".jpg";
            String profile = resourceConfig.getPortrait() + hUserPhoneNr + ".jpg";
            boolean result = FileUtil.base64ToImage(fileBase64, destPath);

            user.setsUserProfileUrl(profile);
            editTUserSummary(user);

            if (result != false) {
                return profile;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}