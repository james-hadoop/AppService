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
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;

@RestController
@RequestMapping("/v1/service")
public class HsUserController {
    private static final Logger logger = LoggerFactory.getLogger(HsUserController.class);

    @Autowired
    private IHsUserService hsUserService;

    @RequestMapping(value = "/getTUserSummary", method = RequestMethod.GET)
    public GridContent TUserSummary(@RequestParam(value = "sUserNameStr") String sUserNameStr, @RequestParam(value = "sUserEmailStr") String sUserEmailStr,
                    @RequestParam(value = "hUserPhoneNr") Integer hUserPhoneNr) {
        logger.info("/v1/service/getTUserSummary() called: sUserNameStr={}, sUserNameStr={}, hUserPhoneNr={}", sUserNameStr, sUserNameStr, hUserPhoneNr);
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
}
