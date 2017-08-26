package com.leyao.app_service.entity.hs_user;

import java.util.Date;

public class SUserProfile {
    private Long sUserProfileId;

    private Long hUserId;

    private String sUserProfileUrl;

    private Date createTs;

    private Date updateTs;

    public Long getsUserProfileId() {
        return sUserProfileId;
    }

    public void setsUserProfileId(Long sUserProfileId) {
        this.sUserProfileId = sUserProfileId;
    }

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public String getsUserProfileUrl() {
        return sUserProfileUrl;
    }

    public void setsUserProfileUrl(String sUserProfileUrl) {
        this.sUserProfileUrl = sUserProfileUrl;
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