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
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;

@RestController
@RequestMapping("/v1/service/user")
public class HsUserController {
    private static final Logger logger = LoggerFactory.getLogger(HsUserController.class);

    @Autowired
    private IHsUserService hsUserService;

    /**
     * @apiGroup User
     * 
     * @apiName getTUserSummary
     * 
     * @api {get} /v1/service/user/getTUserSummary 获取用户详情
     * 
     * @apiParam {String} sessionCode Logined user session code.
     * @apiParam {String} hUserPhoneNr User phone number.
     * 
     * @apiSuccessExample {json} Success-Response:
     *  {
     *      "rows": [ 
     *          { 
     *              "hUserId": 1,
     *              "hUserPhoneNr": 13333333333, "sUserGenderCd": 0,
     *              "sUserGenderDesc": "?", "sUserNameStr": "?",
     *              "sUserProfileUrl": "?", "sUserEmailStr": "?",
     *              "sUserActiveInd": 0, "createTs": 946656000000,
     *              "updateTs": 946656000000, "sUserPasswordStr": null,
     *              "verifyCode": null 
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
    @RequestMapping(value = "/getTUserSummary", method = RequestMethod.GET)
    public GridContent TUserSummary(@RequestParam(value = "sUserNameStr", required = false) String sUserNameStr, @RequestParam(value = "sUserEmailStr", required = false) String sUserEmailStr,
                    @RequestParam(value = "hUserPhoneNr") String hUserPhoneNr, @RequestParam(value = "sessionCode", required = true) String sessionCode) {
        logger.info("/v1/service/user/getTUserSummary() called: sessionCode={}, sUserNameStr={}, sUserEmailStr={}, hUserPhoneNr={}", sessionCode, sUserNameStr, sUserNameStr, hUserPhoneNr);
        GridContent gridContent = new GridContent();

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("sUserNameStr", sUserNameStr);
        paramMap.put("sUserEmailStr", sUserEmailStr);
        paramMap.put("hUserPhoneNr", hUserPhoneNr);

        List<TUserSummary> tUserSummaryList = hsUserService.getTUserSummary(paramMap);
        gridContent.setRows(tUserSummaryList);
        gridContent.setTotal(null == tUserSummaryList ? 0 : tUserSummaryList.size());

        return gridContent;
    }

    /**
     * @apiGroup User
     * 
     * @apiName getVerifyCode
     * 
     * @api {post} /v1/service/user/getVerifyCode 获取注册验证码
     * 
     * @apiParam {String} hUserPhoneNr User phone number.
     * 
     * @apiSuccessExample {json} Success-Response:
     *  1234
     * 
     * @apiSuccessExample {json} Error-Response:
     *  -1
     */
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.POST)
    public String getVerifyCode(@RequestParam(value = "hUserPhoneNr", required = true) String hUserPhoneNr) {
        logger.info("/v1/service/user/getVerifyCode() called: hUserPhoneNr={}", hUserPhoneNr);

        String verifyCode = String.valueOf(Response.ERROR);

        try {
            verifyCode = hsUserService.getVerifyCode(hUserPhoneNr);
        } catch (Exception e) {
            logger.error("/v1/service/user/getVerifyCode()", e);
            return verifyCode;
        }

        return verifyCode;
    }

    /**
     * @apiGroup User
     * 
     * @apiName regist
     * 
     * @api {post} /v1/service/user/regist 注册
     * 
     * @apiParam {String} hUserPhoneNr User phone number.
     * @apiParam {String} sUserPasswordStr User password.
     * @apiParam {Number} verifyCode Verify code.
     * 
     * @apiSuccessExample {json} Success-Response: 
     *  {
     *      "responseResult": "SUCCESS",
     *      "responseResultMsg": "Regist success"
     *  }
     * 
     * @apiSuccessExample {json} Error-Response:
     *  {
     *      "responseResult": "ERROR",
     *      "responseResultMsg": "Regist fail"
     *  }
     */
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent regist(@RequestBody TUserSummary tUserSummary) {
        logger.info("/v1/service/user/regist() called: hUserPhoneNr={}, verifyCode={}", tUserSummary.gethUserPhoneNr(), tUserSummary.getVerifyCode());
        ResponseContent responseContent = new ResponseContent();

        try {
            int result = hsUserService.regist(tUserSummary);
            if (Response.ERROR == result) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Regist fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Regist success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/user/regist()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }

    /**
     * @apiGroup User
     * 
     * @apiName login
     * 
     * @api {post} /v1/service/user/login 登录
     * 
     * @apiParam {String} hUserPhoneNr User phone number.
     * @apiParam {String} sUserPasswordStr User password.
     * 
     * @apiSuccessExample {json} Success-Response: 
     *  { 
     *      "responseResult": "SUCCESS",
     *      "responseResultMsg": "SNb5412b7c-7fdf-4d6e-add4-04ba9f7821932017-09-14 10:20:01" 
     *  }
     * 
     * @apiSuccessExample {json} Error-Response: 
     *  {
     *      "responseResult": "ERROR",
     *      "responseResultMsg": "Login fail" 
     *  }
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent login(@RequestBody TUserSummary tUserSummary) {
        logger.info("/v1/service/user/login() called: hUserPhoneNr={}", tUserSummary.gethUserPhoneNr());
        ResponseContent responseContent = new ResponseContent();

        try {
            String sessionCode = hsUserService.login(tUserSummary);
            if (null == sessionCode) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Login fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg(sessionCode);
            }
        } catch (Exception e) {
            logger.error("/v1/service/user/login()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }

    /**
     * @apiGroup User
     * 
     * @apiName reset
     * 
     * @api {post} /v1/service/user/reset 重置
     * 
     * @apiParam {String} hUserPhoneNr User phone number.
     * @apiParam {String} sUserPasswordStr User password.
     * @apiParam {Number} verifyCode Verify code.
     * 
     * @apiSuccessExample {json} Success-Response: 
     *  {
     *      "responseResult": "SUCCESS",
     *      "responseResultMsg": "Reset success"
     *  }
     * 
     * @apiSuccessExample {json} Error-Response: 
     *  {
     *      "responseResult": "ERROR",
     *      "responseResultMsg": "Login fail" 
     *  }
     */
    @RequestMapping(value = "reset", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent reset(@RequestBody TUserSummary tUserSummary) {
        logger.info("/v1/service/user/reset() called: hUserPhoneNr={}, verifyCode={}", tUserSummary.gethUserPhoneNr(), tUserSummary.getVerifyCode());
        ResponseContent responseContent = new ResponseContent();

        try {
            int resutl = hsUserService.reset(tUserSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResult(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("reset fail");
            } else {
                responseContent.setResponseResult(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("reset success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/user/reset()", e);
            responseContent.setResponseResult(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }
}
