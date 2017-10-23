package com.app_service.service;

import java.util.List;
import java.util.Map;

import com.app_service.entity.ls_user_message.LUserMessage;
import com.app_service.entity.ls_user_message.TUserMessageSummary;

public interface ILsUserMessageService {
    List<LUserMessage> getLUserMessageList(Map<String, Object> paramMap);

    int getLUserMessageListCount(Map<String, Object> paramMap);

    int addTUserMessageSummary(TUserMessageSummary tUserMessageSummary);
}
