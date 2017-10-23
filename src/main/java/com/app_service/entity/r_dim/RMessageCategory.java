package com.app_service.entity.r_dim;

import java.util.Date;

public class RMessageCategory {
    private Integer rMessageCategoryCd;

    private String rMessageCategoryDesc;

    private Date createTs;

    private Date updateTs;

    public Integer getrMessageCategoryCd() {
        return rMessageCategoryCd;
    }

    public void setrMessageCategoryCd(Integer rMessageCategoryCd) {
        this.rMessageCategoryCd = rMessageCategoryCd;
    }

    public String getrMessageCategoryDesc() {
        return rMessageCategoryDesc;
    }

    public void setrMessageCategoryDesc(String rMessageCategoryDesc) {
        this.rMessageCategoryDesc = rMessageCategoryDesc;
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