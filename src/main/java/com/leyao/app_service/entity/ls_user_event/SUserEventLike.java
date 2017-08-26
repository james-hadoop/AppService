package com.leyao.app_service.entity.ls_user_event;

import java.util.Date;

public class SUserEventLike {
    private Long sUserEventLikeId;

    private Long lUserEventId;

    private Integer sUserEventLikeInd;

    private Date createTs;

    private Date updateTs;

    public Long getsUserEventLikeId() {
        return sUserEventLikeId;
    }

    public void setsUserEventLikeId(Long sUserEventLikeId) {
        this.sUserEventLikeId = sUserEventLikeId;
    }

    public Long getlUserEventId() {
        return lUserEventId;
    }

    public void setlUserEventId(Long lUserEventId) {
        this.lUserEventId = lUserEventId;
    }

    public Integer getsUserEventLikeInd() {
        return sUserEventLikeInd;
    }

    public void setsUserEventLikeInd(Integer sUserEventLikeInd) {
        this.sUserEventLikeInd = sUserEventLikeInd;
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