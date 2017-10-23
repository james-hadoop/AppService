package com.app_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_service.dao.configuration.DimensionConfig;
import com.app_service.dao.mapper.r_dim.REventCategoryMapper;
import com.app_service.entity.r_dim.REventCategory;
import com.app_service.service.IDimensionConfigService;

@Service
public class DimensionConfigServiceImpl implements IDimensionConfigService {
    @Autowired
    REventCategoryMapper rEventCategoryMapper;

    @Override
    public void initDimensionConfig() {
        List<REventCategory> rEventCategoryList = rEventCategoryMapper.getAll();

        for (REventCategory record : rEventCategoryList) {
            DimensionConfig.rEventCategoryEnumList.add(record.getrEventCategoryCd(), record.getrEventCategoryDesc());
        }
    }
}
