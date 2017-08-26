package com.leyao.app_service.entity.hs_user;

import java.util.Date;

public class SUserName {
    private Long sUserNameId;

    private Long hUserId;

    private String sUserNameStr;

    private Date createTs;

    private Date updateTs;

    public Long getsUserNameId() {
        return sUserNameId;
    }

    public void setsUserNameId(Long sUserNameId) {
        this.sUserNameId = sUserNameId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public String getsUserNameStr() {
        return sUserNameStr;
    }

    public void setsUserNameStr(String sUserNameStr) {
        this.sUserNameStr = sUserNameStr;
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