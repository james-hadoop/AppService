package com.leyao.app_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leyao.app_service.entity.GridContent;
import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;
import com.leyao.app_service.service.IHsEventService;
import com.leyao.app_service.service.ILeyaoAppService;

@RestController
@RequestMapping("/v1/service")
public class LeyaoAppServiceController {
    private static final Logger logger = LoggerFactory.getLogger(LeyaoAppServiceController.class);

    @Autowired
    ILeyaoAppService leyaoServiceService;

    @Autowired
    IHsEventService hsEventService;

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public GridContent getItemUrls(@RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows,
            @RequestParam(value = "sEventTypeCd", defaultValue = "-1") Integer sEventTypeCd) {
        logger.info("/v1/service/getEvents() called: sEventTypeCd={}, page={}, rows={}", sEventTypeCd, page, rows);
        GridContent gridcontent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("sEventTypeCd", sEventTypeCd);
            paramMap.put("start", start);
            paramMap.put("end", end);

            List<TEventPage> listLeyaoEvent = leyaoServiceService.getTEventPageList(paramMap);
            int count = leyaoServiceService.getTEventPageListCount(paramMap);

            gridcontent.setRows(listLeyaoEvent);
            gridcontent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/getEvents()", e);
            return gridcontent;
        }

        return gridcontent;
    }

    @RequestMapping(value = "/getTEventSummary", method = RequestMethod.GET)
    public GridContent getTEventSummary(@RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows,
            @RequestParam(value = "sEventCategoryCd", defaultValue = "-1") Integer sEventCategoryCd,
            @RequestParam(value = "sEventTypeCd", defaultValue = "-1") Integer sEventTypeCd) {
        logger.info("/v1/service/getTEventPageListForRecom() called: sEventCategoryCd={},sEventTypeCd={}, page={}, rows={}", sEventCategoryCd,sEventTypeCd,
                page, rows);
        GridContent gridcontent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("sEventCategoryCd", sEventCategoryCd);
            paramMap.put("sEventTypeCd", sEventTypeCd);
            paramMap.put("start", start);
            paramMap.put("end", end);

            // List<TEventSummary> getTEventPageListForRecom(Map<String, Object>
            // paramMap);
            List<TEventSummary> tEventSummaryList = hsEventService.getTEventSummary(paramMap);
            int count = hsEventService.getTEventSummaryCount(paramMap);

            gridcontent.setRows(tEventSummaryList);
            gridcontent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/getTEventPageListForRecom()", e);
            return gridcontent;
        }

        return gridcontent;
    }
}