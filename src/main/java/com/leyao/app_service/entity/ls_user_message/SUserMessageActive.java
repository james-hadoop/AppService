package com.leyao.app_service.entity.ls_user_message;

import java.util.Date;

public class SUserMessageActive {
    private Long sUserMessageActiveId;

    private Long lUserMessageId;

    private Integer sUserMessageActiveInd;

    private Date createTs;

    private Date updateTs;

    public Long getsUserMessageActiveId() {
        return sUserMessageActiveId;
    }

    public void setsUserMessageActiveId(Long sUserMessageActiveId) {
        this.sUserMessageActiveId = sUserMessageActiveId;
    }

    public Long getlUserMessageId() {
        return lUserMessageId;
    }

    public void setlUserMessageId(Long lUserMessageId) {
        this.lUserMessageId = lUserMessageId;
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