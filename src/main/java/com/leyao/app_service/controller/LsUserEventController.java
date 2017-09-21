package com.leyao.app_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leyao.app_service.common.Response;
import com.leyao.app_service.entity.ResponseContent;
import com.leyao.app_service.entity.enums.ResponseResultEnum;
import com.leyao.app_service.entity.ls_user_event.TUserEventSummary;
import com.leyao.app_service.service.ILsUserEventService;

@RestController
@RequestMapping("/v1/service/event")
public class LsUserEventController {
    private static final Logger logger = LoggerFactory.getLogger(LsUserEventController.class);

    @Autowired
    ILsUserEventService lsUserEventService;

    /**
     * @apiGroup User-Event
     * 
     * @apiName feedbackTEventSummary
     * 
     * @api {post} /v1/service/event/feedbackTEventSummary 添加用户反馈
     * 
     * @apiParam {Number} hUserPhoneNr User phone number.
     * @apiParam {Number} hEventId Event ID.
     * @apiParam {String} rUserEventCategory Event Category.
     * @apiParam {String} sUserEventLikeInd User like code.
     * @apiParam {String} sUserEventReadLogTxt User feedback text.
     *
     * @apiSuccessExample {json} Success-Response: 
     *  {
     *      "responseResult": "SUCCESS",
     *      "responseResultMsg": "Feedback success"
     *  }
     * 
     * @apiSuccessExample {json} Error-Response: 
     *  {
     *      "responseResult": "ERROR",
     *      "responseResultMsg": "Feedback fail" 
     *  }
     */
    @RequestMapping(value = "/feedbackTEventSummary", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent feedbackTEventSummary(@RequestBody TUserEventSummary tUserEventSummary) {
        logger.info("/v1/service/event/feedbackTEventSummary() called: hUserPhoneNr={},hEventId={},rUserEventCategory={},sUserEventLikeInd={},sUserEventReadLogTxt={}",
                        tUserEventSummary.gethUserPhoneNr(), tUserEventSummary.gethEventId(), tUserEventSummary.getrUserEventCategory(), tUserEventSummary.getsUserEventLikeInd(),
                        tUserEventSummary.getsUserEventReadLogTxt());
        ResponseContent responseContent = new ResponseContent();

        try {
            int resutl = lsUserEventService.feedbackTUserEventSummary(tUserEventSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Feedback fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Feedback success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/event/addTEventSummary()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }

        return responseContent;
    }
}