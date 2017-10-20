package com.leyao.app_service.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leyao.app_service.common.Response;
import com.leyao.app_service.dao.mapper.hs_message.HsMessageMapper;
import com.leyao.app_service.dao.mapper.hs_message.SMessageActiveMapper;
import com.leyao.app_service.dao.mapper.hs_message.SMessageCategoryMapper;
import com.leyao.app_service.dao.mapper.hs_message.SMessageContentMapper;
import com.leyao.app_service.dao.mapper.ls_user_message.LUserMessageMapper;
import com.leyao.app_service.dao.mapper.ls_user_message.SUserMessageActiveMapper;
import com.leyao.app_service.entity.enums.StatusEnum;
import com.leyao.app_service.entity.hs_message.HsMessage;
import com.leyao.app_service.entity.hs_message.SMessageActive;
import com.leyao.app_service.entity.hs_message.SMessageCategory;
import com.leyao.app_service.entity.hs_message.SMessageContent;
import com.leyao.app_service.entity.hs_message.TMessageSummary;
import com.leyao.app_service.entity.ls_user_message.LUserMessage;
import com.leyao.app_service.entity.ls_user_message.SUserMessageActive;
import com.leyao.app_service.service.IHsMessageService;
import com.leyao.app_service.util.HsMessageUtil;
import com.leyao.app_service.util.LsUserMessageUtil;

@Service
public class HsMessageServiceImpl implements IHsMessageService {
    @Autowired
    SMessageContentMapper sMessageContentMapper;

    @Autowired
    HsMessageMapper hsMessageMapper;

    @Autowired
    SMessageActiveMapper sMessageActiveMapper;

    @Autowired
    SMessageCategoryMapper sMessageCategoryMapper;

    @Autowired
    LUserMessageMapper lUserMessageMapper;

    @Autowired
    SUserMessageActiveMapper sUserMessageActiveMapper;

    @Override
    public List<TMessageSummary> getTMessageSummaryList(Map<String, Object> paramMap) {
        return sMessageContentMapper.getTMessageSummaryList(paramMap);
    }

    @Override
    public int getTMessageSummaryListCount(Map<String, Object> paramMap) {
        return sMessageContentMapper.getTMessageSummaryListCount(paramMap);
    }

    @Override
    @Transactional
    public int addTMessageSummary(TMessageSummary tMessageSummary) {
        Date timestamp = new Date();
        tMessageSummary.setCreateTs(timestamp);
        tMessageSummary.setUpdateTs(timestamp);

        // HsMessage
        HsMessage hsMessage = HsMessageUtil.messageSummary2Message(tMessageSummary);
        hsMessageMapper.insertSelective(hsMessage);
        long messageId = hsMessageMapper.getMaxHMessageId();

        tMessageSummary.sethMessageId(messageId);

        // SMessageActive
        SMessageActive sMessageActive = HsMessageUtil.messageSummary2MessageActive(tMessageSummary);
        sMessageActiveMapper.insertSelective(sMessageActive);

        // SMessageCategory
        SMessageCategory sMessageCategory = HsMessageUtil.messageSummary2MessageCategory(tMessageSummary);
        sMessageCategoryMapper.insertSelective(sMessageCategory);

        // SMessageContent
        SMessageContent sMessageContent = HsMessageUtil.messageSummary2MessageContent(tMessageSummary);
        sMessageContentMapper.insertSelective(sMessageContent);

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int editTMessageSummary(TMessageSummary tMessageSummary) {
        Date timestamp = new Date();
        tMessageSummary.setUpdateTs(timestamp);

        // HsMessage
        HsMessage hsMessage = HsMessageUtil.messageSummary2Message(tMessageSummary);
        hsMessageMapper.updateByPrimaryKeySelective(hsMessage);

        // SMessageActive
        SMessageActive sMessageActive = HsMessageUtil.messageSummary2MessageActive(tMessageSummary);
        sMessageActiveMapper.updateByPrimaryKeySelective(sMessageActive);

        // SMessageCategory
        SMessageCategory sMessageCategory = HsMessageUtil.messageSummary2MessageCategory(tMessageSummary);
        sMessageCategoryMapper.updateByPrimaryKeySelective(sMessageCategory);

        // SMessageContent
        SMessageContent sMessageContent = HsMessageUtil.messageSummary2MessageContent(tMessageSummary);
        sMessageContentMapper.updateByPrimaryKeySelective(sMessageContent);

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int deleteTMessageSummary(TMessageSummary tMessageSummary) {
        Date timestamp = new Date();
        tMessageSummary.setUpdateTs(timestamp);
        tMessageSummary.setsMessageActiveInd(StatusEnum.Unactive.getCode());

        // SMessageActive
        SMessageActive sMessageActive = HsMessageUtil.messageSummary2MessageActive(tMessageSummary);
        sMessageActiveMapper.updateByPrimaryKeySelective(sMessageActive);

        return Response.SUCCESS;
    }

    @Override
    public List<TMessageSummary> getTMessageSummaryListByCondition(Map<String, Object> paramMap) {
        return sMessageContentMapper.getTMessageSummaryListByCondition(paramMap);
    }

    @Override
    public int getTMessageSummaryListByConditionCount(Map<String, Object> paramMap) {
        return sMessageContentMapper.getTMessageSummaryListByConditionCount(paramMap);
    }

    @Override
    @Transactional
    public int associateTMessageSummary(Long hMessageId, List<Long> rowUserIds) {
        if (null == hMessageId || null == rowUserIds || 0 == rowUserIds.size()) {
            return Response.ERROR;
        }

        List<LUserMessage> lUserMessageList = LsUserMessageUtil.makeLsUserMessageList(hMessageId, rowUserIds);
        if (null == lUserMessageList || 0 == lUserMessageList.size()) {
            return Response.ERROR;
        }

        for (LUserMessage lUserMessage : lUserMessageList) {
            lUserMessageMapper.insertSelective(lUserMessage);

            long lUserMessageId = lUserMessageMapper.getMaxLUserMessageId();
            lUserMessage.setlUserMessageId(lUserMessageId);
            SUserMessageActive sUserMessageActive = LsUserMessageUtil.userMessage2UserMessageActive(lUserMessage);
            sUserMessageActiveMapper.insertSelective(sUserMessageActive);
        }

        return Response.SUCCESS;
    }
}