package com.leyao.app_service.entity.ls_user_event;

import java.util.Date;

public class SUserEventActive {
    private Long sUserEventActiveId;

    private Long lUserEventId;

    private Integer sUserEventActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsUserEventActiveId() {
        return sUserEventActiveId;
    }

    public void setsUserEventActiveId(Long sUserEventActiveId) {
        this.sUserEventActiveId = sUserEventActiveId;
    }

    public Long getlUserEventId() {
        return lUserEventId;
    }

    public void setlUserEventId(Long lUserEventId) {
        this.lUserEventId = lUserEventId;
    }

    public Integer getsUserEventActiveInd() {
        return sUserEventActiveInd;
    }

    public void setsUserEventActiveInd(Integer sUserEventActiveInd) {
        this.sUserEventActiveInd = sUserEventActiveInd;
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