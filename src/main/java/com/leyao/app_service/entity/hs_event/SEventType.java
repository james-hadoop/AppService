package com.leyao.app_service.entity.hs_event;

import java.util.Date;

public class SEventType {
    private Long sEventTypeId;

    private Long hEventId;

    private Integer sEventTypeCd;

    private Date createTs;

    private Date updateTs;

    public Long getsEventTypeId() {
        return sEventTypeId;
    }

    public void setsEventTypeId(Long sEventTypeId) {
        this.sEventTypeId = sEventTypeId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public Integer getsEventTypeCd() {
        return sEventTypeCd;
    }

    public void setsEventTypeCd(Integer sEventTypeCd) {
        this.sEventTypeCd = sEventTypeCd;
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