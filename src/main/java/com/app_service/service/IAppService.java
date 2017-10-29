package com.app_service.service;

import java.util.List;
import java.util.Map;

import com.app_service.entity.hs_event.TEventPage;

public interface IAppService {
    List<TEventPage> getTEventPageList(Map<String, Object> paramMap);

    int getTEventPageListCount(Map<String, Object> paramMap);
}