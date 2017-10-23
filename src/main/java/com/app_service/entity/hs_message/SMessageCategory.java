package com.app_service.entity.hs_message;

import java.util.Date;

public class SMessageCategory {
    private Long sMessageContentId;

    private Long hMessageId;

    private Integer sMessageCategoryCd;

    private Date createTs;

    private Date updateTs;

    public Long getsMessageContentId() {
        return sMessageContentId;
    }

    public void setsMessageContentId(Long sMessageContentId) {
        this.sMessageContentId = sMessageContentId;
    }

    public Long gethMessageId() {
        return hMessageId;
    }

    public void sethMessageId(Long hMessageId) {
        this.hMessageId = hMessageId;
    }

    public Integer getsMessageCategoryCd() {
        return sMessageCategoryCd;
    }

    public void setsMessageCategoryCd(Integer sMessageCategoryCd) {
        this.sMessageCategoryCd = sMessageCategoryCd;
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