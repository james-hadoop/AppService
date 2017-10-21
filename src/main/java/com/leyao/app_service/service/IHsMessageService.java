package com.leyao.app_service.service;

import java.util.List;
import java.util.Map;

import com.leyao.app_service.entity.hs_message.TMessageSummary;

public interface IHsMessageService {
    List<TMessageSummary> getTMessageSummaryList(Map<String, Object> paramMap);

    int getTMessageSummaryListCount(Map<String, Object> paramMap);

    List<TMessageSummary> getTMessageSummaryListByCondition(Map<String, Object> paramMap);

    int getTMessageSummaryListByConditionCount(Map<String, Object> paramMap);
    
    List<TMessageSummary> getTMessageSummaryListByConditionGlobal(Map<String, Object> paramMap);

    int getTMessageSummaryListByConditionCountGlobal(Map<String, Object> paramMap);

    int addTMessageSummary(TMessageSummary tMessageSummary);

    int editTMessageSummary(TMessageSummary tMessageSummary);

    int deleteTMessageSummary(TMessageSummary tMessageSummary);

    int associateTMessageSummary(Long hMessageId, List<Long> rowUserIds);
}