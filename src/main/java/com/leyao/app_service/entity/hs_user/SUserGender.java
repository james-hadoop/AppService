package com.leyao.app_service.entity.hs_user;

import java.util.Date;

public class SUserGender {
    private Long sUserGenderId;

    private Long hUserId;

    private Integer sUserGenderCd;

    private Date createTs;

    private Date updateTs;

    public Long getsUserGenderId() {
        return sUserGenderId;
    }

    public void setsUserGenderId(Long sUserGenderId) {
        this.sUserGenderId = sUserGenderId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public Integer getsUserGenderCd() {
        return sUserGenderCd;
    }

    public void setsUserGenderCd(Integer sUserGenderCd) {
        this.sUserGenderCd = sUserGenderCd;
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