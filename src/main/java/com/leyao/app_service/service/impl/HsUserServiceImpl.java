package com.leyao.app_service.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leyao.app_service.common.Response;
import com.leyao.app_service.common.SessionManager;
import com.leyao.app_service.common.VerifyCodeManager;
import com.leyao.app_service.dao.mapper.hs_user.HUserMapper;
import com.leyao.app_service.dao.mapper.hs_user.SUserActiveMapper;
import com.leyao.app_service.dao.mapper.hs_user.SUserFeedbackMapper;
import com.leyao.app_service.dao.mapper.hs_user.SUserPasswordMapper;
import com.leyao.app_service.dao.mapper.hs_user.TUserPageMapper;
import com.leyao.app_service.entity.hs_user.HUser;
import com.leyao.app_service.entity.hs_user.SUserActive;
import com.leyao.app_service.entity.hs_user.SUserFeedback;
import com.leyao.app_service.entity.hs_user.SUserFeedbackSummary;
import com.leyao.app_service.entity.hs_user.SUserPassword;
import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;
import com.leyao.app_service.util.CommonUtil;
import com.leyao.app_service.util.HsUserUtil;
import com.leyao.app_service.util.VerifyCodeUtil;

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
        VerifyCodeUtil.sendPhoneVerifyCode(verifyCode, hUserPhoneNr);

        return verifyCode;
    }

    @Override
    public TUserSummary selectByhUserPhoneNr(Long hUserPhoneNr) {
        return tUserPageMapper.selectByhUserPhoneNr(hUserPhoneNr);
    }

    @Override
    public int editTUserSummary(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
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
    public int addSUserFeedbackSummary(SUserFeedbackSummary sUserFeedbackSummary) {
        Long hUserPhoneNr = sUserFeedbackSummary.gethUserPhoneNr();
        if (null == hUserPhoneNr) {
            return Response.ERROR;
        }

        HUser hUser = hUserMapper.selectByPrimaryKey(hUserPhoneNr);
        if (null == hUser) {
            return Response.ERROR;
        }

        sUserFeedbackSummary.sethUserId(hUser.gethUserId());

        SUserFeedback sUserFeedback = HsUserUtil.userFeedbackSummanry2UserFeedback(sUserFeedbackSummary);
        return sUserFeedbackMapper.insertSelective(sUserFeedback);
    }
}
