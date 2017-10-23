package com.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_service.dao.mapper.ls_user_message.LUserMessageMapper;
import com.app_service.dao.mapper.ls_user_message.SUserMessageActiveMapper;
import com.app_service.entity.ls_user_message.LUserMessage;
import com.app_service.entity.ls_user_message.TUserMessageSummary;
import com.app_service.service.ILsUserMessageService;

@Service
public class LsUserMessageServiceImpl implements ILsUserMessageService {
    @Autowired
    LUserMessageMapper lUserMessageMapper;

    @Autowired
    SUserMessageActiveMapper sUserMessageActiveMapper;

    @Override
    public List<LUserMessage> getLUserMessageList(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLUserMessageListCount(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addTUserMessageSummary(TUserMessageSummary tUserMessageSummary) {
        // TODO Auto-generated method stub
        return 0;
    }
}
