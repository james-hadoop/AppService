package com.leyao.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.dao.mapper.hs_user.TUserPageMapper;
import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int login(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
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
    public int getIdentifyingCode(TUserSummary tUserSummary) {
        // TODO Auto-generated method stub
        return 0;
    }

}
