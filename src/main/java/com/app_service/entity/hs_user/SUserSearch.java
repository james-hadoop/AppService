package com.app_service.entity.hs_user;

import java.util.Date;

public class SUserSearch {
    private Long sUserSearchId;

    private Long hUserId;

    private String sUserFeedbackStr;

    private Date createTs;

    private Date updateTs;

    public Long getsUserSearchId() {
        return sUserSearchId;
    }

    public void setsUserSearchId(Long sUserSearchId) {
        this.sUserSearchId = sUserSearchId;
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
}