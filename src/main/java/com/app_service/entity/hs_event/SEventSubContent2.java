package com.app_service.entity.hs_event;

import java.util.Date;

public class SEventSubContent2 {
    private Long sEventSubContent2Id;

    private Long hEventId;

    private String sEventSubContent2Str;

    private Date createTs;

    private Date updateTs;

    public Long getsEventSubContent2Id() {
        return sEventSubContent2Id;
    }

    public void setsEventSubContent2Id(Long sEventSubContent2Id) {
        this.sEventSubContent2Id = sEventSubContent2Id;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public String getsEventSubContent2Str() {
        return sEventSubContent2Str;
    }

    public void setsEventSubContent2Str(String sEventSubContent2Str) {
        this.sEventSubContent2Str = sEventSubContent2Str;
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