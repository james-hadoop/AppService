package com.leyao.app_service.entity.r_dim;

import java.util.Date;

public class RUserGender {
    private Integer rUserGenderCd;

    private String rUserGenderDesc;

    private Date createTs;

    private Date updateTs;

    public Integer getrUserGenderCd() {
        return rUserGenderCd;
    }

    public void setrUserGenderCd(Integer rUserGenderCd) {
        this.rUserGenderCd = rUserGenderCd;
    }

    public String getrUserGenderDesc() {
        return rUserGenderDesc;
    }

    public void setrUserGenderDesc(String rUserGenderDesc) {
        this.rUserGenderDesc = rUserGenderDesc;
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