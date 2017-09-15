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
@RequestMapping("/v1/service/event")
public class HsEventController {
    private static final Logger logger = LoggerFactory.getLogger(HsEventController.class);

    @Autowired
    ILeyaoAppService leyaoServiceService;

    @Autowired
    IHsEventService hsEventService;

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public GridContent getItemUrls(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "sEventTypeCd", defaultValue = "-1") Integer sEventTypeCd, @RequestParam(value = "sessionCode", required = true) String sessionCode) {
        logger.info("/v1/service/event/getEvents() called: sessionCode={}, sEventTypeCd={}, page={}, rows={}", sessionCode, sEventTypeCd, page, rows);
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
            logger.error("/v1/service/event/getEvents()", e);
            return gridcontent;
        }

        return gridcontent;
    }

    /**
     * @apiGroup Event
     * 
     * @apiName getTEventSummaryByType
     * 
     * @api {get} /v1/service/event/getTEventSummaryByType 根据事件类型获取事件
     * 
     * @apiParam {String} sessionCode Logined user session code.
     * @apiParam {Number} sEventTypeCd Event type.
     * @apiParam {Number} [page] Optional Paging - page number.
     * @apiParam {Number} [rows] Optional Paging - rows in one page.
     * 
     * @apiSuccessExample {json} Success-Response:
     *  {
     *      "rows": [
     *          {
     *              "hEventId": 7,
     *              "sEventCategoryCd": 0,
     *              "rEventCategoryDesc": "d1",
     *              "sEventTypeCd": 1,
     *              "rEventTypeDesc": "vedio",
     *              "sEventTitleUrl": "vedio/1.mp4",
     *              "sEventContentUrl": "vedio/1.mp4",
     *              "sEventActiveInd": 0,
     *              "createTs": 946627200000,
     *              "updateTs": 946627200000,
     *              "sEventSearchContentTxt": "7",
     *              "sEventSubContent1UrlList": [],
     *              "sEventSubContent2StrList": [],
     *              "sEventBannerPositionCd": null,
     *              "sEventRecomPositionCd": null
     *          }
     *      ],
     *      "total": 1
     *  }
     * 
     * @apiSuccessExample {json} Error-Response: 
     *  {
     *      "rows":[],
     *      "total":0
     *  }
     */
    @RequestMapping(value = "/getTEventSummaryByType", method = RequestMethod.GET)
    public GridContent getTEventSummaryByType(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "sEventTypeCd", defaultValue = "-1") Integer sEventTypeCd, @RequestParam(value = "sessionCode", required = true) String sessionCode) {
        logger.info("/v1/service/event/getTEventSummaryByType() called: sessionCode={}, sEventTypeCd={}, page={}, rows={}", sessionCode, sEventTypeCd, page, rows);
        GridContent gridcontent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("sEventTypeCd", sEventTypeCd);
            paramMap.put("start", start);
            paramMap.put("end", end);

            List<TEventSummary> tEventSummaryList = hsEventService.getTEventSummaryByType(paramMap);
            int count = hsEventService.getTEventSummaryByTypeCount(paramMap);

            // List<TEventSummary> tEventSummaryList = new
            // ArrayList<TEventSummary>();
            // int count = 0;

            gridcontent.setRows(tEventSummaryList);
            gridcontent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/event/getTEventSummaryByType()", e);
            return gridcontent;
        }

        return gridcontent;
    }

    /**
     * @apiGroup Event
     * 
     * @apiName getTEventSummaryByCategory
     * 
     * @api {get} /v1/service/event/getTEventSummaryByCategory 根据事件类目获取事件
     * 
     * @apiParam {String} sessionCode Logined user session code.
     * @apiParam {Number} sEventCategoryCd Event category
     * @apiParam {Number} [page] Optional Paging - page number.
     * @apiParam {Number} [rows] Optional Paging - rows in one page.
     * 
     * @apiSuccessExample {json} Success-Response:
     *  {
     *      "rows": [
     *          {
     *              "hEventId": 7,
     *              "sEventCategoryCd": 0,
     *              "rEventCategoryDesc": "d1",
     *              "sEventTypeCd": 1,
     *              "rEventTypeDesc": "vedio",
     *              "sEventTitleUrl": "vedio/1.mp4",
     *              "sEventContentUrl": "vedio/1.mp4",
     *              "sEventActiveInd": 0,
     *              "createTs": 946627200000,
     *              "updateTs": 946627200000,
     *              "sEventSearchContentTxt": "7",
     *              "sEventSubContent1UrlList": [],
     *              "sEventSubContent2StrList": [],
     *              "sEventBannerPositionCd": null,
     *              "sEventRecomPositionCd": null
     *          }
     *      ],
     *      "total": 1
     *  }
     * 
     * @apiSuccessExample {json} Error-Response: 
     *  {
     *      "rows":[],
     *      "total":0
     *  }
     */
    @RequestMapping(value = "/getTEventSummaryByCategory", method = RequestMethod.GET)
    public GridContent getTEventSummaryByCategory(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "sEventCategoryCd", defaultValue = "-1") Integer sEventCategoryCd, @RequestParam(value = "sessionCode", required = true) String sessionCode) {
        logger.info("/v1/service/event/getTEventSummaryByCategory() called: sessionCode={}, sEventCategoryCd={}, page={}, rows={}", sessionCode, sEventCategoryCd, page, rows);
        GridContent gridcontent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("sEventCategoryCd", sEventCategoryCd);
            paramMap.put("start", start);
            paramMap.put("end", end);

            List<TEventSummary> tEventSummaryList = hsEventService.getTEventSummaryByCategory(paramMap);
            int count = hsEventService.getTEventSummaryByCategoryCount(paramMap);

            gridcontent.setRows(tEventSummaryList);
            gridcontent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/event/getTEventSummaryByCategory()", e);
            return gridcontent;
        }

        return gridcontent;
    }

    /**
     * @apiGroup Event
     * 
     * @apiName getTEventSummaryForBanner
     * 
     * @api {get} /v1/service/event/getTEventSummaryForBanner 获取Banner事件
     * 
     * @apiParam {String} sessionCode Logined user session code.
     * @apiParam {Number} sEventCategoryCd Event category
     * @apiParam {Number} [page] Optional Paging - page number.
     * @apiParam {Number} [rows] Optional Paging - rows in one page.
     * 
     * @apiSuccessExample {json} Success-Response:
     *  {
     *      "rows": [
     *          {
     *              "hEventId": 7,
     *              "sEventCategoryCd": 0,
     *              "rEventCategoryDesc": "d1",
     *              "sEventTypeCd": 1,
     *              "rEventTypeDesc": "vedio",
     *              "sEventTitleUrl": "vedio/1.mp4",
     *              "sEventContentUrl": "vedio/1.mp4",
     *              "sEventActiveInd": 0,
     *              "createTs": 946627200000,
     *              "updateTs": 946627200000,
     *              "sEventSearchContentTxt": "7",
     *              "sEventSubContent1UrlList": [],
     *              "sEventSubContent2StrList": [],
     *              "sEventBannerPositionCd": null,
     *              "sEventRecomPositionCd": null
     *          }
     *      ],
     *      "total": 1
     *  }
     * 
     * @apiSuccessExample {json} Error-Response: 
     *  {
     *      "rows":[],
     *      "total":0
     *  }
     */
    @RequestMapping(value = "/getTEventSummaryForBanner", method = RequestMethod.GET)
    public GridContent getTEventSummaryForBanner(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "sessionCode", required = true) String sessionCode) {
        logger.info("/v1/service/event/getTEventSummaryForBanner() called: sessionCode={}, page={}, rows={}", sessionCode, page, rows);
        GridContent gridcontent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("start", start);
            paramMap.put("end", end);

            List<TEventSummary> tEventSummaryList = hsEventService.getTEventPageListForBanner(paramMap);
            int count = hsEventService.getTEventPageListForBannerCount(paramMap);

            gridcontent.setRows(tEventSummaryList);
            gridcontent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/event/getTEventSummaryForBanner()", e);
            return gridcontent;
        }

        return gridcontent;
    }

    /**
     * @apiGroup Event
     * 
     * @apiName checkUpdate
     * 
     * @api {get} /v1/service/event/checkUpdate 获取事件最新版本
     * 
     * @apiParam {String} eventVersion Event version.
     * 
     * @apiSuccessExample {json} Success-Response: 
     * 1505223163561
     * 
     * @apiSuccessExample {json} Error-Response: 
     * 1505223163561
     */
    @RequestMapping(value = "/checkUpdate", method = RequestMethod.GET)
    public String checkUpdate(@RequestParam(value = "eventVersion") String eventVersion) {
        return hsEventService.checkUpdate(eventVersion);
    }
}