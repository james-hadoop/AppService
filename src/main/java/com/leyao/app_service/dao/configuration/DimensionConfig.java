package com.leyao.app_service.dao.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leyao.app_service.dao.mapper.r_dim.REventCategoryMapper;
import com.leyao.app_service.dao.mapper.r_dim.REventPositionMapper;
import com.leyao.app_service.dao.mapper.r_dim.REventTypeMapper;
import com.leyao.app_service.dao.mapper.r_dim.RMessageCategoryMapper;
import com.leyao.app_service.dao.mapper.r_dim.RUserGenderMapper;
import com.leyao.app_service.entity.r_dim.REventCategory;
import com.leyao.app_service.entity.r_dim.REventPosition;
import com.leyao.app_service.entity.r_dim.REventType;
import com.leyao.app_service.entity.r_dim.RMessageCategory;
import com.leyao.app_service.entity.r_dim.RUserGender;

public class DimensionConfig {
    public List<String> R_EVENT_ACTIVT_LIST = new ArrayList<String>();

    public List<String> R_EVENT_CATEGORY_LIST = new ArrayList<String>();

    public List<String> R_EVENT_POSITION_LIST = new ArrayList<String>();

    public List<String> R_EVENT_TYPE_LIST = new ArrayList<String>();

    public List<String> R_MESSAGE_CATEGORY_LIST = new ArrayList<String>();

    public List<String> R_USER_GENDER_LIST = new ArrayList<String>();

    @Autowired
    REventCategoryMapper rEventCategoryMapper;

    @Autowired
    REventPositionMapper rEventPositionMapper;

    @Autowired
    REventTypeMapper rEventTypeMapper;

    @Autowired
    RMessageCategoryMapper rMessageCategoryMapper;

    @Autowired
    RUserGenderMapper rUserGenderMapper;

    private static DimensionConfig instance;

    private DimensionConfig() {
        this.initDimensionConfig();
    }

    private void initDimensionConfig() {
        System.out.println("rEventCategoryMapper="+rEventCategoryMapper);
        
        List<REventCategory> rEventCategoryList = rEventCategoryMapper.getAll();

        List<REventPosition> rEventPositionList = rEventPositionMapper.getAll();

        List<REventType> rEventTypeList = rEventTypeMapper.getAll();

        List<RMessageCategory> rMessageCategoryList = rMessageCategoryMapper.getAll();

        List<RUserGender> rUserGenderList = rUserGenderMapper.getAll();

        for (REventCategory record : rEventCategoryList) {
            this.R_EVENT_CATEGORY_LIST.set(record.getrEventCategoryCd(), record.getrEventCategoryDesc());
        }

        for (REventType record : rEventTypeList) {
            this.R_EVENT_TYPE_LIST.set(record.getrEventTypeCd(), record.getrEventTypeDesc());
        }

        for (REventPosition record : rEventPositionList) {
            this.R_EVENT_POSITION_LIST.set(record.getrEventPositionCd(), record.getrEventPositionDesc());
        }

        for (RMessageCategory record : rMessageCategoryList) {
            this.R_MESSAGE_CATEGORY_LIST.set(record.getrMessageCategoryCd(), record.getrMessageCategoryDesc());
        }

        for (RUserGender record : rUserGenderList) {
            this.R_USER_GENDER_LIST.set(record.getrUserGenderCd(), record.getrUserGenderDesc());
        }
    }

    public static DimensionConfig getInstance() {
        if (null == instance) {
            instance = new DimensionConfig();
        }

        return instance;
    }
}