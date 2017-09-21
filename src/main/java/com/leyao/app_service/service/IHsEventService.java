package com.leyao.app_service.service;

import java.util.List;
import java.util.Map;

import com.leyao.app_service.entity.hs_event.TEventSummary;
import com.leyao.app_service.entity.ls_user_event.TUserEventSummary;

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
    
    int addTEventSummary(TEventSummary tEventSummary);
    
    List<TEventSummary> getTEventSummaryByCondition(Map<String, Object> paramMap);

    int getTEventSummaryByConditionCount(Map<String, Object> paramMap);
}