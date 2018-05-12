package com.app_service.entity;

import com.app_service.common.GlobalConstant;

public class ProfileFile {
    private String sessionCode = GlobalConstant.DEFAULT_SESSION_CODE;
    private Long hUserPhoneNr;
    private String fileName;
    private String base64;
    private String currentPortraitName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    public Long gethUserPhoneNr() {
        return hUserPhoneNr;
    }

    public void sethUserPhoneNr(Long hUserPhoneNr) {
        this.hUserPhoneNr = hUserPhoneNr;
    }

    public String getCurrentPortraitName() {
        return currentPortraitName;
    }

    public void setCurrentPortraitName(String currentPortraitName) {
        this.currentPortraitName = currentPortraitName;
    }
}
