package com.leyao.app_service.service;

import java.util.List;
import java.util.Map;

import com.leyao.app_service.entity.hs_user.TUserSummary;

public interface IHsUserService {
    List<TUserSummary> getTUserSummary(Map<String, Object> paramMap);
    
    int regist(TUserSummary tUserSummary);
    
    int login(TUserSummary tUserSummary);
    
    int logout(TUserSummary tUserSummary);
    
    int reset(TUserSummary tUserSummary);
    
    int getIdentifyingCode(TUserSummary tUserSummary);
}
