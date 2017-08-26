package com.leyao.app_service.entity.ls_user_message;

import java.util.Date;

public class LUserMessage {
    private Long lUserMessageId;

    private Long hUserId;

    private Long hMessageId;

    private Date createTs;

    private Date updateTs;

    public Long getlUserMessageId() {
        return lUserMessageId;
    }

    public void setlUserMessageId(Long lUserMessageId) {
        this.lUserMessageId = lUserMessageId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public Long gethMessageId() {
        return hMessageId;
    }

    public void sethMessageId(Long hMessageId) {
        this.hMessageId = hMessageId;
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