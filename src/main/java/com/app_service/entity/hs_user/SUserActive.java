package com.app_service.entity.hs_user;

import java.util.Date;

public class SUserActive {
    private Long sUserActiveId;

    private Long hUserId;

    private Integer sUserActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsUserActiveId() {
        return sUserActiveId;
    }

    public void setsUserActiveId(Long sUserActiveId) {
        this.sUserActiveId = sUserActiveId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public Integer getsUserActiveInd() {
        return sUserActiveInd;
    }

    public void setsUserActiveInd(Integer sUserActiveInd) {
        this.sUserActiveInd = sUserActiveInd;
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