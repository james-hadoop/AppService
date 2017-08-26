package com.leyao.app_service.entity.ls_user_event;

import java.util.Date;

public class SUserEventRead {
    private Long sUserEventReadId;

    private Long lUserEventId;

    private Date createTs;

    private Date updateTs;

    private String sUserEventReadLogTxt;

    public Long getsUserEventReadId() {
        return sUserEventReadId;
    }

    public void setsUserEventReadId(Long sUserEventReadId) {
        this.sUserEventReadId = sUserEventReadId;
    }

    public Long getlUserEventId() {
        return lUserEventId;
    }

    public void setlUserEventId(Long lUserEventId) {
        this.lUserEventId = lUserEventId;
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

    public String getsUserEventReadLogTxt() {
        return sUserEventReadLogTxt;
    }

    public void setsUserEventReadLogTxt(String sUserEventReadLogTxt) {
        this.sUserEventReadLogTxt = sUserEventReadLogTxt;
    }
}