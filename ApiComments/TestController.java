package com.app_service.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app_service.dao.configuration.DimensionConfig;
import com.app_service.dao.mapper.hs_event.HsEventMapper;
import com.app_service.dao.mapper.hs_event.TestSEventActiveMapper;
import com.app_service.entity.GridContent;
import com.app_service.entity.hs_event.HsEvent;
import com.app_service.entity.hs_event.TEventPage;
import com.app_service.service.IDimensionConfigService;
import com.app_service.util.CommonUtil;

@RestController
@RequestMapping("/v1/test")
public class TestController {
    @Autowired
    HsEventMapper hsEventMapper;

    @Autowired
    TestSEventActiveMapper sEventActiveMapper;

    @RequestMapping(value = "/insertHsEvent", method = RequestMethod.GET)
    public void insertHsEvent() {
        Date date = CommonUtil.getCurrentTimestamp();

        HsEvent event = new HsEvent();
        event.setCreateTs(date);

        hsEventMapper.insertSelective(event);
    }

    @RequestMapping(value = "/getHsEvent", method = RequestMethod.GET)
    public GridContent getHsEvent() {
        GridContent gridcontent = new GridContent();

        List<HsEvent> hsEventList = hsEventMapper.getAllHsEvent();

        gridcontent.setRows(hsEventList);
        gridcontent.setTotal(hsEventList.size());

        return gridcontent;
    }

    @RequestMapping(value = "/getAllSEventActive", method = RequestMethod.GET)
    public GridContent getAllSEventActive() {
        GridContent gridcontent = new GridContent();

        List<TEventPage> sEventActiveList = sEventActiveMapper.getAllSEventActive();

        gridcontent.setRows(sEventActiveList);
        gridcontent.setTotal(sEventActiveList.size());

        return gridcontent;
    }

    @RequestMapping(value = "/insertSEventActive", method = RequestMethod.GET)
    public void insertSEventActive() {
        List<TEventPage> sEventActiveList = sEventActiveMapper.getAllSEventActive();
        for (TEventPage es : sEventActiveList) {
            sEventActiveMapper.insertSelective(es);
        }
    }

    @RequestMapping(value = "/testDimensionConfig", method = RequestMethod.GET)
    public void testDimensionConfig() {
        System.out.println("DimensionConfig: " + DimensionConfig.rEventCategoryEnumList.size());
        for (String record : DimensionConfig.rEventCategoryEnumList) {
            System.out.println("\t" + record);
        }
    }
}
