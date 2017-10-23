package com.app_service.entity.hs_event;

import java.util.Date;

public class SEventRecom2 {
    private Long sEventRecom2Id;

    private Long hEventId;

    private Integer sEventRecomPositionCd;

    private Integer sEventRecomActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsEventRecom2Id() {
        return sEventRecom2Id;
    }

    public void setsEventRecom2Id(Long sEventRecom2Id) {
        this.sEventRecom2Id = sEventRecom2Id;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public Integer getsEventRecomPositionCd() {
        return sEventRecomPositionCd;
    }

    public void setsEventRecomPositionCd(Integer sEventRecomPositionCd) {
        this.sEventRecomPositionCd = sEventRecomPositionCd;
    }

    public Integer getsEventRecomActiveInd() {
        return sEventRecomActiveInd;
    }

    public void setsEventRecomActiveInd(Integer sEventRecomActiveInd) {
        this.sEventRecomActiveInd = sEventRecomActiveInd;
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