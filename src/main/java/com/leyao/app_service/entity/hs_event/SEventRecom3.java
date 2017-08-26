package com.leyao.app_service.entity.hs_event;

import java.util.Date;

public class SEventRecom3 {
    private Long sEventRecom3Id;

    private Long hEventId;

    private Integer sEventRecomPositionCd;

    private Integer sEventRecomActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsEventRecom3Id() {
        return sEventRecom3Id;
    }

    public void setsEventRecom3Id(Long sEventRecom3Id) {
        this.sEventRecom3Id = sEventRecom3Id;
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