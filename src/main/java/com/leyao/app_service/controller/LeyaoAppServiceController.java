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
import com.leyao.app_service.entity.TEventPage;
import com.leyao.app_service.service.ILeyaoAppService;

@RestController
@RequestMapping("/v1/service")
public class LeyaoAppServiceController {
    private static final Logger logger = LoggerFactory.getLogger(LeyaoAppServiceController.class);

    @Autowired
    ILeyaoAppService leyaoServiceService;

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public GridContent getItemUrls(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "sEventTypeCd", defaultValue = "-1") Integer sEventTypeCd) {
        logger.info("/v1/service/getEvents() called: sEventTypeCd={}, page={}, rows={}", sEventTypeCd, page, rows);
        GridContent gridcontent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("sEventTypeCd", sEventTypeCd);

            List<TEventPage> listLeyaoEvent = leyaoServiceService.getAllTEventPage(paramMap);
            int count = leyaoServiceService.getAllTEventPageCount(paramMap);

            gridcontent.setRows(listLeyaoEvent);
            gridcontent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/getEvents()", e);
            return gridcontent;
        }

        return gridcontent;
    }
}