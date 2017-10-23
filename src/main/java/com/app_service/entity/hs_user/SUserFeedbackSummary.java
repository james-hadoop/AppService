package com.app_service.entity.hs_user;

import java.util.Date;

public class SUserFeedbackSummary {
    private Long sUserFeedbackId;

    private Long hUserId;

    private String sUserFeedbackStr;

    private Date createTs;

    private Date updateTs;
    
    private Long hUserPhoneNr;

    public Long getsUserFeedbackId() {
        return sUserFeedbackId;
    }

    public void setsUserFeedbackId(Long sUserFeedbackId) {
        this.sUserFeedbackId = sUserFeedbackId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public String getsUserFeedbackStr() {
        return sUserFeedbackStr;
    }

    public void setsUserFeedbackStr(String sUserFeedbackStr) {
        this.sUserFeedbackStr = sUserFeedbackStr;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public Long gethUserPhoneNr() {
        return hUserPhoneNr;
    }

    public void sethUserPhoneNr(Long hUserPhoneNr) {
        this.hUserPhoneNr = hUserPhoneNr;
    }
}