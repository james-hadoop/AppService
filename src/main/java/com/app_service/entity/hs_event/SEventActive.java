package com.app_service.entity.hs_event;

import java.util.Date;

public class SEventActive {
    private Long sEventActiveId;

    private Long hEventId;

    private Integer sEventActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsEventActiveId() {
        return sEventActiveId;
    }

    public void setsEventActiveId(Long sEventActiveId) {
        this.sEventActiveId = sEventActiveId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public Integer getsEventActiveInd() {
        return sEventActiveInd;
    }

    public void setsEventActiveInd(Integer sEventActiveInd) {
        this.sEventActiveInd = sEventActiveInd;
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