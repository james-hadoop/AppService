package com.app_service.entity.hs_user;

import java.util.Date;

public class SUserEmail {
    private Long sUserEmailId;

    private Long hUserId;

    private String sUserEmailStr;

    private Date createTs;

    private Date updateTs;

    public Long getsUserEmailId() {
        return sUserEmailId;
    }

    public void setsUserEmailId(Long sUserEmailId) {
        this.sUserEmailId = sUserEmailId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public String getsUserEmailStr() {
        return sUserEmailStr;
    }

    public void setsUserEmailStr(String sUserEmailStr) {
        this.sUserEmailStr = sUserEmailStr;
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