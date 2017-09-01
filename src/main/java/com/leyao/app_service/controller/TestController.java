package com.leyao.app_service.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leyao.app_service.dao.mapper.hs_event.HsEventMapper;
import com.leyao.app_service.entity.GridContent;
import com.leyao.app_service.entity.hs_event.HsEvent;
import com.leyao.app_service.util.AppServiceUtil;

@RestController
@RequestMapping("/v1/test")
public class TestController {
    @Autowired
    HsEventMapper hsEventMapper;

    @RequestMapping(value = "/insertHsEvent", method = RequestMethod.GET)
    public void insertHsEvent() {
        Date date = AppServiceUtil.getCurrentTimestamp();

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
}
