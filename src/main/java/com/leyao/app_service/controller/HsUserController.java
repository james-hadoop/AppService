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
import com.leyao.app_service.common.VerifyCodeManager;
import com.leyao.app_service.entity.GridContent;
import com.leyao.app_service.entity.ResponseContent;
import com.leyao.app_service.entity.enums.ResponseResultEnum;
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;
import com.leyao.app_service.util.VerifyCodeUtil;

@RestController
@RequestMapping("/v1/service/user")
public class HsUserController {
    private static final Logger logger = LoggerFactory.getLogger(HsUserController.class);

    @Autowired
    private IHsUserService hsUserService;

    @RequestMapping(value = "/getTUserSummary", method = RequestMethod.GET)
    public GridContent TUserSummary(@RequestParam(value = "sUserNameStr") String sUserNameStr,
            @RequestParam(value = "sUserEmailStr") String sUserEmailStr,
            @RequestParam(value = "hUserPhoneNr") Integer hUserPhoneNr) {
        logger.info("/v1/service/getTUserSummary() called: sUserNameStr={}, sUserNameStr={}, hUserPhoneNr={}",
                sUserNameStr, sUserNameStr, hUserPhoneNr);
        GridContent gridcontent = new GridContent();

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("sUserNameStr", sUserNameStr);
        paramMap.put("sUserEmailStr", sUserEmailStr);
        paramMap.put("hUserPhoneNr", hUserPhoneNr);

        List<TUserSummary> tUserSummaryList = hsUserService.getTUserSummary(paramMap);
        gridcontent.setRows(tUserSummaryList);
        gridcontent.setTotal(tUserSummaryList.size());

        return gridcontent;
    }

    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.POST)
    public String getVerifyCode(@RequestParam(value = "hUserPhoneNr", required = true) String hUserPhoneNr) {
        logger.info("/v1/service/user/getVerifyCode() called: hUserPhoneNr={}", hUserPhoneNr);

        String verifyCode = String.valueOf(Response.ERROR);

        try {
            verifyCode = VerifyCodeManager.generateVerifyCode(hUserPhoneNr);
            VerifyCodeUtil.sendPhoneVerifyCode(verifyCode, hUserPhoneNr);
        } catch (Exception e) {
            logger.error("/v1/service/user/getVerifyCode()", e);
            return verifyCode;
        }

        return verifyCode;
    }

    @RequestMapping(value = "regist", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent regist(@RequestBody TUserSummary tUserSummary) {
        logger.info("/v1/service/regist() called: hUserPhoneNr={}, verifyCode={}", tUserSummary.gethUserPhoneNr(),
                tUserSummary.getVerifyCode());
        ResponseContent responseContent = new ResponseContent();

        try {
            int resutl = hsUserService.regist(tUserSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResultEnum(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Regist fail");
            } else {
                responseContent.setResponseResultEnum(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Regist success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/user/regist()", e);
            responseContent.setResponseResultEnum(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContent login(@RequestBody TUserSummary tUserSummary) {
        logger.info("/v1/service/login() called: hUserPhoneNr={}", tUserSummary.gethUserPhoneNr());
        ResponseContent responseContent = new ResponseContent();

        try {
            int resutl = hsUserService.login(tUserSummary);
            if (Response.ERROR == resutl) {
                responseContent.setResponseResultEnum(ResponseResultEnum.ERROR);
                responseContent.setResponseResultMsg("Login fail");
            } else {
                responseContent.setResponseResultEnum(ResponseResultEnum.SUCCESS);
                responseContent.setResponseResultMsg("Login success");
            }
        } catch (Exception e) {
            logger.error("/v1/service/user/login()", e);
            responseContent.setResponseResultEnum(ResponseResultEnum.ERROR);
            responseContent.setResponseResultMsg("Server internal error");
            return responseContent;
        }
        return responseContent;
    }
}
