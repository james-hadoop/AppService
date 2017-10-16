package com.leyao.app_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.dao.configuration.DimensionConfig;
import com.leyao.app_service.dao.mapper.hs_event.SEventCategoryMapper;
import com.leyao.app_service.entity.hs_event.SEventCategory;
import com.leyao.app_service.service.IDimensionConfigService;

@Service
public class DimensionConfigServiceImpl implements IDimensionConfigService {
    @Autowired
    SEventCategoryMapper sEventCategoryMapper;

    @Override
    public void initDimensionConfig() {
        List<SEventCategory> sEventCategoryList = sEventCategoryMapper.getAll();
        for (SEventCategory record : sEventCategoryList) {
            DimensionConfig.rEventCategoryEnumList.set(record.getsEventCategoryCd(),
                    String.valueOf(record.getsEventCategoryCd()));
        }
    }
}
