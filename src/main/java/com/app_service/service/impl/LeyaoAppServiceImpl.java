package com.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_service.dao.mapper.hs_event.TEventPageMapper;
import com.app_service.entity.hs_event.TEventPage;
import com.app_service.service.ILeyaoAppService;

@Service
public class LeyaoAppServiceImpl implements ILeyaoAppService {
    @Autowired
    TEventPageMapper tEventPageMapper;

    @Override
    public List<TEventPage> getTEventPageList(Map<String, Object> paramMap) {
        return tEventPageMapper.getTEventPageList(paramMap);
    }

    @Override
    public int getTEventPageListCount(Map<String, Object> paramMap) {
        return tEventPageMapper.getTEventPageListCount(paramMap);
    }
}