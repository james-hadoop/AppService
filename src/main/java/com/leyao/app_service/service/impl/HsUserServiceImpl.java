package com.leyao.app_service.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.common.Response;
import com.leyao.app_service.common.VerifyCodeManager;
import com.leyao.app_service.dao.mapper.hs_user.TUserPageMapper;
import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;
import com.leyao.app_service.util.CommonUtil;
import com.leyao.app_service.util.HsUserUtil;

@Service
public class HsUserServiceImpl implements IHsUserService {
    @Autowired
    TUserPageMapper tUserPageMapper;

    @Override
    public List<TUserSummary> getTUserSummary(Map<String, Object> paramMap) {
        List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);
        List<TUserSummary> userSummaryList = HsUserUtil.userPage2UserSummary(userPageList);

        return userSummaryList;
    }

    @Override
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
        
        tUserSummary.setsUserPasswordStr(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()));
        TUserPage userPage = HsUserUtil.userSummary2UserPage(tUserSummary);
        tUserPageMapper.insertSelective(userPage);
        return Response.SUCCESS;
    }

    @Override
    public int login(TUserSummary tUserSummary) {
        if (null == tUserSummary || null == tUserSummary.gethUserPhoneNr()
                || null == tUserSummary.getsUserPasswordStr()) {
            return Response.ERROR;
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("hUserPhoneNr", tUserSummary.gethUserPhoneNr());
        List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);

        if (null == userPageList || 0 == userPageList.size()) {
            return Response.ERROR;
        }

        return Response.SUCCESS;
    }

    @Override
    public int logout(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int reset(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getVerifyCode(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
    }

}
