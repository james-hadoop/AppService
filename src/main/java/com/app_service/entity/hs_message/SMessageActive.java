package com.app_service.entity.hs_message;

import java.util.Date;

public class SMessageActive {
    private Long sMessageActiveId;

    private Long hMessageId;

    private Integer sMessageActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsMessageActiveId() {
        return sMessageActiveId;
    }

    public void setsMessageActiveId(Long sMessageActiveId) {
        this.sMessageActiveId = sMessageActiveId;
    }

    public Long gethMessageId() {
        return hMessageId;
    }

    public void sethMessageId(Long hMessageId) {
        this.hMessageId = hMessageId;
    }

    public Integer getsMessageActiveInd() {
        return sMessageActiveInd;
    }

    public void setsMessageActiveInd(Integer sMessageActiveInd) {
        this.sMessageActiveInd = sMessageActiveInd;
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