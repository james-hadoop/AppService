package com.app_service.entity.r_dim;

import java.util.Date;

public class REventType {
    private Integer rEventTypeCd;

    private String rEventTypeDesc;

    private Date createTs;

    private Date updateTs;

    public Integer getrEventTypeCd() {
        return rEventTypeCd;
    }

    public void setrEventTypeCd(Integer rEventTypeCd) {
        this.rEventTypeCd = rEventTypeCd;
    }

    public String getrEventTypeDesc() {
        return rEventTypeDesc;
    }

    public void setrEventTypeDesc(String rEventTypeDesc) {
        this.rEventTypeDesc = rEventTypeDesc;
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