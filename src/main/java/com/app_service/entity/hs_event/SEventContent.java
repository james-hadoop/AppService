package com.app_service.entity.hs_event;

import java.util.Date;

public class SEventContent {
    private Long sEventContentId;

    private Long hEventId;

    private String sEventTitleUrl;

    private String sEventContentUrl;

    private Date createTs;

    private Date updateTs;

    public Long getsEventContentId() {
        return sEventContentId;
    }

    public void setsEventContentId(Long sEventContentId) {
        this.sEventContentId = sEventContentId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public String getsEventTitleUrl() {
        return sEventTitleUrl;
    }

    public void setsEventTitleUrl(String sEventTitleUrl) {
        this.sEventTitleUrl = sEventTitleUrl;
    }

    public String getsEventContentUrl() {
        return sEventContentUrl;
    }

    public void setsEventContentUrl(String sEventContentUrl) {
        this.sEventContentUrl = sEventContentUrl;
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