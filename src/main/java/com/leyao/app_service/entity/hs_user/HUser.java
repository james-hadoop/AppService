package com.leyao.app_service.entity.hs_user;

import java.util.Date;

public class HUser {
    private Long hUserId;

    private Integer hUserPhoneNr;

    private Date createTs;

    private Date updateTs;

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public Integer gethUserPhoneNr() {
        return hUserPhoneNr;
    }

    public void sethUserPhoneNr(Integer hUserPhoneNr) {
        this.hUserPhoneNr = hUserPhoneNr;
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