package com.leyao.app_service.entity.hs_user;

import java.util.Date;

public class TUserSummary {
    private Long hUserId;

    private Integer hUserPhoneNr;

    private Integer sUserGenderCd;

    private String sUserGenderDesc;

    private String sUserNameStr;

    private String sUserProfileUrl;

    private String sUserEmailStr;

    private Integer sUserActiveInd;

    private Date createTs;

    private Date updateTs;
    
    private String sUserPasswordStr;

    public Long gethUserId() {
        return hUserId;
    }

    public void sethUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public Integer gethUserPhoneNr() {
        return hUserPhoneNr;
    }

    public void sethUserPhoneNr(Integer hUserPhoneNr) {
        this.hUserPhoneNr = hUserPhoneNr;
    }

    public Integer getsUserGenderCd() {
        return sUserGenderCd;
    }

    public void setsUserGenderCd(Integer sUserGenderCd) {
        this.sUserGenderCd = sUserGenderCd;
    }

    public String getsUserGenderDesc() {
        return sUserGenderDesc;
    }

    public void setsUserGenderDesc(String sUserGenderDesc) {
        this.sUserGenderDesc = sUserGenderDesc;
    }

    public String getsUserNameStr() {
        return sUserNameStr;
    }

    public void setsUserNameStr(String sUserNameStr) {
        this.sUserNameStr = sUserNameStr;
    }

    public String getsUserProfileUrl() {
        return sUserProfileUrl;
    }

    public void setsUserProfileUrl(String sUserProfileUrl) {
        this.sUserProfileUrl = sUserProfileUrl;
    }

    public String getsUserEmailStr() {
        return sUserEmailStr;
    }

    public void setsUserEmailStr(String sUserEmailStr) {
        this.sUserEmailStr = sUserEmailStr;
    }

    public Integer getsUserActiveInd() {
        return sUserActiveInd;
    }

    public void setsUserActiveInd(Integer sUserActiveInd) {
        this.sUserActiveInd = sUserActiveInd;
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