package com.leyao.app_service.entity.ls_user_event;

import java.util.Date;

public class TUserEventSummary {
    private Long lUserEventId;

    private Long hUserId;

    private Long hEventId;

    private Integer sUserEventActiveInd;

    private Integer sUserEventLikeInd;

    private String sUserEventReadLogTxt;

    private Date createTs;

    private Date updateTs;

    private Long hUserPhoneNr;

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

    public Integer getsUserEventActiveInd() {
        return sUserEventActiveInd;
    }

    public void setsUserEventActiveInd(Integer sUserEventActiveInd) {
        this.sUserEventActiveInd = sUserEventActiveInd;
    }

    public Integer getsUserEventLikeInd() {
        return sUserEventLikeInd;
    }

    public void setsUserEventLikeInd(Integer sUserEventLikeInd) {
        this.sUserEventLikeInd = sUserEventLikeInd;
    }

    public String getsUserEventReadLogTxt() {
        return sUserEventReadLogTxt;
    }

    public void setsUserEventReadLogTxt(String sUserEventReadLogTxt) {
        this.sUserEventReadLogTxt = sUserEventReadLogTxt;
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

    public Long gethUserPhoneNr() {
        return hUserPhoneNr;
    }

    public void sethUserPhoneNr(Long hUserPhoneNr) {
        this.hUserPhoneNr = hUserPhoneNr;
    }
}
