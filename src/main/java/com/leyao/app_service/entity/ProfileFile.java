package com.leyao.app_service.entity;

import com.leyao.app_service.common.GlobalConstant;

public class ProfileFile {
    private String sessionCode = GlobalConstant.DEFAULT_SESSION_CODE;
    private String hUserPhoneNr;
    private String fileName;
    private String base64;

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

    public String gethUserPhoneNr() {
        return hUserPhoneNr;
    }

    public void sethUserPhoneNr(String hUserPhoneNr) {
        this.hUserPhoneNr = hUserPhoneNr;
    }
}
