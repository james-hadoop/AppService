package com.app_service.entity.hs_user;

import java.util.Date;

public class SUserPassword {
    private Long sUserPasswordId;

    private Long hUserId;

    private String sUserPasswordStr;

    private Date createTs;

    private Date updateTs;

    public Long getsUserPasswordId() {
        return sUserPasswordId;
    }

    public void setsUserPasswordId(Long sUserPasswordId) {
        this.sUserPasswordId = sUserPasswordId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public String getsUserPasswordStr() {
        return sUserPasswordStr;
    }

    public void setsUserPasswordStr(String sUserPasswordStr) {
        this.sUserPasswordStr = sUserPasswordStr;
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