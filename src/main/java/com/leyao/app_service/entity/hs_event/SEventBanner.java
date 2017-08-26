package com.leyao.app_service.entity.hs_event;

import java.util.Date;

public class SEventBanner {
    private Long sEventBannerId;

    private Long hEventId;

    private Integer sEventBannerPositionCd;

    private Integer sEventBannerActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsEventBannerId() {
        return sEventBannerId;
    }

    public void setsEventBannerId(Long sEventBannerId) {
        this.sEventBannerId = sEventBannerId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public Integer getsEventBannerPositionCd() {
        return sEventBannerPositionCd;
    }

    public void setsEventBannerPositionCd(Integer sEventBannerPositionCd) {
        this.sEventBannerPositionCd = sEventBannerPositionCd;
    }

    public Integer getsEventBannerActiveInd() {
        return sEventBannerActiveInd;
    }

    public void setsEventBannerActiveInd(Integer sEventBannerActiveInd) {
        this.sEventBannerActiveInd = sEventBannerActiveInd;
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