package com.leyao.app_service.service;

import java.util.List;
import java.util.Map;

import com.leyao.app_service.entity.hs_user.SUserFeedbackSummary;
import com.leyao.app_service.entity.hs_user.TUserSummary;

public interface IHsUserService {
    List<TUserSummary> getTUserSummary(Map<String, Object> paramMap);

    int regist(TUserSummary tUserSummary);

    String login(TUserSummary tUserSummary);

    int logout(TUserSummary tUserSummary);

    int reset(TUserSummary tUserSummary);

    String getVerifyCode(String hUserPhoneNr);

    TUserSummary selectByhUserPhoneNr(Long hUserPhoneNr);

    int editTUserSummary(TUserSummary tUserSummary);

    List<SUserFeedbackSummary> getSUserFeedbackSummaryByCondition(Map<String, Object> paramMap);

    int getSUserFeedbackSummaryByConditionCount(Map<String, Object> paramMap);

    int addSUserFeedbackSummary(SUserFeedbackSummary sUserFeedbackSummary);
}
