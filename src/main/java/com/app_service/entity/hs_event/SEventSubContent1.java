package com.app_service.entity.hs_event;

import java.util.Date;

public class SEventSubContent1 {
    private Long sEventSubContent1Id;

    private Long hEventId;

    private String sEventSubContent1Url;

    private Date createTs;

    private Date updateTs;

    public Long getsEventSubContent1Id() {
        return sEventSubContent1Id;
    }

    public void setsEventSubContent1Id(Long sEventSubContent1Id) {
        this.sEventSubContent1Id = sEventSubContent1Id;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public String getsEventSubContent1Url() {
        return sEventSubContent1Url;
    }

    public void setsEventSubContent1Url(String sEventSubContent1Url) {
        this.sEventSubContent1Url = sEventSubContent1Url;
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