package com.leyao.app_service.service;

import java.util.Map;

import com.leyao.app_service.entity.ls_user_message.LUserMessage;

public interface ILsUserMessageService {
    LUserMessage getLUserMessage(Map<String, Object> paramMap);
}
