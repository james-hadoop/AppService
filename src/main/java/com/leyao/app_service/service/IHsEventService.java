package com.leyao.app_service.service;

import java.util.List;
import java.util.Map;

import com.leyao.app_service.entity.hs_event.TEventSummary;

public interface IHsEventService {
    String checkUpdate(String eventVersion);

    List<TEventSummary> getTEventSummaryList(Map<String, Object> paramMap);

    int getTEventSummaryListCount(Map<String, Object> paramMap);

    void createHsEvent(TEventSummary record);

    List<TEventSummary> getTEventSummaryByType(Map<String, Object> paramMap);

    int getTEventSummaryByTypeCount(Map<String, Object> paramMap);

    List<TEventSummary> getTEventSummaryByCategory(Map<String, Object> paramMap);

    int getTEventSummaryByCategoryCount(Map<String, Object> paramMap);

    List<TEventSummary> getTEventPageListForBanner(Map<String, Object> paramMap);

    int getTEventPageListForBannerCount(Map<String, Object> paramMap);
    
    int postTEventSummary(TEventSummary tEventSummary);
}