package com.leyao.app_service.service;

import java.util.List;
import java.util.Map;

import com.leyao.app_service.entity.TEventPage;

public interface ILeyaoAppService {
    List<TEventPage> getAllTEventPage(Map<String, Object> paramMap);

    int getAllTEventPageCount(Map<String, Object> paramMap);
}