package com.leyao.app_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leyao.app_service.common.Response;
import com.leyao.app_service.entity.GridContent;
import com.leyao.app_service.entity.ResponseContent;
import com.leyao.app_service.entity.enums.ResponseResultEnum;
import com.leyao.app_service.entity.hs_message.TMessageSummary;
import com.leyao.app_service.entity.ls_user_message.TUserMessageRequest;
import com.leyao.app_service.service.IHsMessageService;

@RestController
@RequestMapping("/v1/service/message")
public class HsMessageController {
    private static final Logger logger = LoggerFactory.getLogger(HsMessageController.class);

    @Autowired
    IHsMessageService hsMessageService;

    @RequestMapping(value = "/addTMessageSummary", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent addTMessageSummary(@RequestBody TMessageSummary tMessageSummary) {
        logger.info("/v1/service/message/addTMessageSummary() called: hMessageId={}", tMessageSummary.gethMessageId());
        ResponseContent responseContent = new ResponseContent();

        try {
            int resutl = hsMessageService.addTMessageSummary(tMessageSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Add fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Add success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/message/addTMessageSummary()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }

    /**
     * @apiGroup Message
     * 
     * @apiName getTMessageSummaryListByCondition
     * 
     * @api {get} /v1/service/message/getTMessageSummaryListByCondition 获取我的消息
     * 
     * @apiParam {String} sessionCode Logined user session code.
     * @apiParam {Number} [page] Paging - page number.
     * @apiParam {Number} [rows] Paging - rows in one page.
     * @apiParam {Number} [hUserPhoneNr] User phone number.
     * @apiParam {Number} [sMessageCategoryCd] Message category code.
     * 
     * @apiSuccessExample {json} Success-Response: 
     * {
     *  "rows": [ 
     *      {
     *          "hMessageId": 7,
     *          "sMessageActiveInd": 0,
     *          "sMessageCategoryCd": 1,
     *          "sMessageContentStr": "great",
     *          "createTs": 946627200000,
     *          "updateTs": 946627200000
     *      }
     *  ],
     *  "total": 1
     * }
     * 
     * @apiSuccessExample {json} Error-Response: 
     * {
     *  "rows":[],
     *  "total":0
     * }
     */
    @RequestMapping(value = "/getTMessageSummaryListByCondition", method = RequestMethod.GET)
    public GridContent getTMessageSummaryListByCondition( @RequestParam(value = "sessionCode", required = true) String sessionCode, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "hUserPhoneNr", required = false) Long hUserPhoneNr, @RequestParam(value = "sMessageCategoryCd", required = false) Integer sMessageCategoryCd) {
        logger.info("/v1/service/message/getTMessageSummaryListByCondition() called: hUserPhoneNr={},sMessageCategoryCd={}", hUserPhoneNr,sMessageCategoryCd);
        GridContent gridContent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("hUserPhoneNr", hUserPhoneNr);
            paramMap.put("sMessageCategoryCd", sMessageCategoryCd);
            paramMap.put("start", start);
            paramMap.put("end", end);

            List<TMessageSummary> tMessageSummaryList = hsMessageService.getTMessageSummaryListByCondition(paramMap);
            int count = hsMessageService.getTMessageSummaryListByConditionCount(paramMap);

            gridContent.setRows(tMessageSummaryList);
            gridContent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/message/getTMessageSummaryListByCondition()", e);
            return gridContent;
        }
        return gridContent;
    }
    
    /**
     * @apiGroup Message
     * 
     * @apiName getTMessageSummaryListByCondition
     * 
     * @api {get} /v1/service/message/getTMessageSummaryListByCondition 获取我的消息
     * 
     * @apiParam {String} sessionCode Logined user session code.
     * @apiParam {Number} [page] Paging - page number.
     * @apiParam {Number} [rows] Paging - rows in one page.
     * @apiParam {Number} [hUserPhoneNr] User phone number.
     * @apiParam {Number} [sMessageCategoryCd] Message category code.
     * 
     * @apiSuccessExample {json} Success-Response: 
     * {
     *  "rows": [ 
     *      {
     *          "hMessageId": 7,
     *          "sMessageActiveInd": 0,
     *          "sMessageCategoryCd": 1,
     *          "sMessageContentStr": "great",
     *          "createTs": 946627200000,
     *          "updateTs": 946627200000
     *      }
     *  ],
     *  "total": 1
     * }
     * 
     * @apiSuccessExample {json} Error-Response: 
     * {
     *  "rows":[],
     *  "total":0
     * }
     */
    @RequestMapping(value = "/getTMessageSummaryListByConditionGlobal", method = RequestMethod.GET)
    public GridContent getTMessageSummaryListByConditionGlobal( @RequestParam(value = "sessionCode", required = true) String sessionCode, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                    @RequestParam(value = "hUserPhoneNr", required = false) Long hUserPhoneNr, @RequestParam(value = "sMessageCategoryCd", required = false) Integer sMessageCategoryCd,@RequestParam(value = "sMessageContentStr", required = false) String sMessageContentStr) {
        logger.info("/v1/service/message/getTMessageSummaryListByCondition() called: hUserPhoneNr={},sMessageCategoryCd={},sMessageContentStr={}", hUserPhoneNr,sMessageCategoryCd,sMessageContentStr);
        GridContent gridContent = new GridContent();

        try {
            int start = (page - 1) * rows;
            int end = rows;

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("hUserPhoneNr", hUserPhoneNr);
            paramMap.put("sMessageCategoryCd", sMessageCategoryCd);
            paramMap.put("sMessageContentStr", sMessageContentStr);
            paramMap.put("start", start);
            paramMap.put("end", end);

            List<TMessageSummary> tMessageSummaryList = hsMessageService.getTMessageSummaryListByConditionGlobal(paramMap);
            int count = hsMessageService.getTMessageSummaryListByConditionCount(paramMap);

            gridContent.setRows(tMessageSummaryList);
            gridContent.setTotal(count);
        } catch (Exception e) {
            logger.error("/v1/service/message/getTMessageSummaryListByCondition()", e);
            return gridContent;
        }
        return gridContent;
    }
    
    @RequestMapping(value = "/editTMessageSummary", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent editTMessageSummary(@RequestBody TMessageSummary tMessageSummary) {
        logger.info("/v1/service/message/editTMessageSummary() called: hMessageId={}", tMessageSummary.gethMessageId());
        ResponseContent responseContent = new ResponseContent();

        try {
            int resutl = hsMessageService.editTMessageSummary(tMessageSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Edit fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Edit success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/message/editTMessageSummary()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }
    
    @RequestMapping(value = "/deleteTMessageSummary", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent deleteTMessageSummary(@RequestBody TMessageSummary tMessageSummary) {
        logger.info("/v1/service/message/deleteTMessageSummary() called: hMessageId={}", tMessageSummary.gethMessageId());
        ResponseContent responseContent = new ResponseContent();
        
        try {
            int resutl = hsMessageService.deleteTMessageSummary(tMessageSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Delete fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Delete success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/message/deleteTMessageSummary()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }
    
    @RequestMapping(value = "/associateTMessageSummary", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent associateTMessageSummary(@RequestBody TUserMessageRequest tUserMessageRequest) {
        logger.info("/v1/service/message/associateTMessageSummary() called: hMessageId={}", tUserMessageRequest.gethMessageId());
        ResponseContent responseContent = new ResponseContent();
        
        try {
            int result = hsMessageService.associateTMessageSummary(tUserMessageRequest.gethMessageId(), tUserMessageRequest.gethUserIds());
            if (Response.ERROR == result) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Delete fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Delete success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/message/associateTMessageSummary()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }
}