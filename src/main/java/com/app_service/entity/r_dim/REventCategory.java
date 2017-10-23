package com.app_service.entity.r_dim;

import java.util.Date;

public class REventCategory {
    private Integer rEventCategoryCd;

    private String rEventCategoryDesc;

    private Date createTs;

    private Date updateTs;

    public Integer getrEventCategoryCd() {
        return rEventCategoryCd;
    }

    public void setrEventCategoryCd(Integer rEventCategoryCd) {
        this.rEventCategoryCd = rEventCategoryCd;
    }

    public String getrEventCategoryDesc() {
        return rEventCategoryDesc;
    }

    public void setrEventCategoryDesc(String rEventCategoryDesc) {
        this.rEventCategoryDesc = rEventCategoryDesc;
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