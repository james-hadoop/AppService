package com.app_service.entity.ls_user_message;

import java.util.Date;

public class TUserMessageSummary {
    private Long lUserMessageId;

    private Long hUserId;

    private Long hMessageId;

    private Integer sUserMessageActiveInd;

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

    public Integer getsUserMessageActiveInd() {
        return sUserMessageActiveInd;
    }

    public void setsUserMessageActiveInd(Integer sUserMessageActiveInd) {
        this.sUserMessageActiveInd = sUserMessageActiveInd;
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
