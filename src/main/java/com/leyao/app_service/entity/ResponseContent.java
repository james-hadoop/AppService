package com.leyao.app_service.entity;

import com.leyao.app_service.entity.enums.ResponseResultEnum;

public class ResponseContent {
    private ResponseResultEnum responseResultEnum;
    private String responseResultMsg;

    public ResponseResultEnum getResponseResultEnum() {
        return responseResultEnum;
    }

    public void setResponseResultEnum(ResponseResultEnum responseResultEnum) {
        this.responseResultEnum = responseResultEnum;
    }

    public String getResponseResultMsg() {
        return responseResultMsg;
    }

    public void setResponseResultMsg(String responseResultMsg) {
        this.responseResultMsg = responseResultMsg;
    }
}
