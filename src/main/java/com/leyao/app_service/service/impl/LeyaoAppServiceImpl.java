package com.leyao.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.dao.mapper.hs_event.TEventPageMapper;
import com.leyao.app_service.entity.TEventPage;
import com.leyao.app_service.service.ILeyaoAppService;

@Service
public class LeyaoAppServiceImpl implements ILeyaoAppService {
    @Autowired
    TEventPageMapper tEventPageMapper;

    @Override
    public List<TEventPage> getAllTEventPage(Map<String, Object> paramMap) {
        return tEventPageMapper.getAllTEventPage();
    }

    @Override
    public int getAllTEventPageCount(Map<String, Object> paramMap) {
        return tEventPageMapper.getAllTEventPageCount();
    }

}