package com.app_service.entity.hs_event;

import java.util.Date;

public class SEventCategory {
    private Long sEventCategoryId;

    private Long hEventId;

    private Integer sEventCategoryCd;

    private Date createTs;

    private Date updateTs;

    public Long getsEventCategoryId() {
        return sEventCategoryId;
    }

    public void setsEventCategoryId(Long sEventCategoryId) {
        this.sEventCategoryId = sEventCategoryId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public Integer getsEventCategoryCd() {
        return sEventCategoryCd;
    }

    public void setsEventCategoryCd(Integer sEventCategoryCd) {
        this.sEventCategoryCd = sEventCategoryCd;
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