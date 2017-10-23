package com.app_service.entity.r_dim;

import java.util.Date;

public class REventPosition {
    private Integer rEventPositionCd;

    private String rEventPositionDesc;

    private Date createTs;

    private Date updateTs;

    public Integer getrEventPositionCd() {
        return rEventPositionCd;
    }

    public void setrEventPositionCd(Integer rEventPositionCd) {
        this.rEventPositionCd = rEventPositionCd;
    }

    public String getrEventPositionDesc() {
        return rEventPositionDesc;
    }

    public void setrEventPositionDesc(String rEventPositionDesc) {
        this.rEventPositionDesc = rEventPositionDesc;
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