package com.app_service.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.app_service.entity.hs_event.SEventSubContent1;
import com.app_service.entity.hs_event.SEventSubContent2;
import com.app_service.entity.hs_event.TEventSummary;

public interface IHsEventService {
    String checkUpdate(String eventVersion);

    List<TEventSummary> getTEventSummaryList(Map<String, Object> paramMap);

    int getTEventSummaryListCount(Map<String, Object> paramMap);

    List<TEventSummary> getTEventSummaryByType(Map<String, Object> paramMap);

    int getTEventSummaryByTypeCount(Map<String, Object> paramMap);

    List<TEventSummary> getTEventSummaryByCategory(Map<String, Object> paramMap);

    int getTEventSummaryByCategoryCount(Map<String, Object> paramMap);

    List<TEventSummary> getTEventPageListForBanner(Map<String, Object> paramMap);

    int getTEventPageListForBannerCount(Map<String, Object> paramMap);
    
    List<TEventSummary> getTEventSummaryByCondition(Map<String, Object> paramMap);

    int getTEventSummaryByConditionCount(Map<String, Object> paramMap);
    
    List<TEventSummary> getTEventSummaryByConditionGlobal(Map<String, Object> paramMap) throws IOException;

    int getTEventSummaryByConditionGlobalCount(Map<String, Object> paramMap);
    
    int addTEventSummary(TEventSummary tEventSummary);
    
    int editTEventSummary(TEventSummary tEventSummary);
    
    int deleteTEventSummary(TEventSummary tEventSummary);
    
    List<SEventSubContent1> getEventSubContent1ByEventId(Long hEventId);
    
    List<SEventSubContent2> getEventSubContent2ByEventId(Long hEventId);
}