package com.leyao.app_service.entity.ls_user_event;

import java.util.Date;

public class LUserEvent {
    private Long lUserEventId;

    private Long hUserId;

    private Long hEventId;

    private Date createTs;

    private Date updateTs;

    public Long getlUserEventId() {
        return lUserEventId;
    }

    public void setlUserEventId(Long lUserEventId) {
        this.lUserEventId = lUserEventId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
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