package com.app_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/global")
public class GlobalController {

    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String errorPage() {
        return "errorPage";
    }
}