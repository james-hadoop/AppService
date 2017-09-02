package com.leyao.app_service.entity.hs_event;

import java.util.Date;

public class TEventPage {
    private Long hEventId;

    private Integer sEventCategoryCd;

    private String rEventCategoryDesc;

    private Integer sEventTypeCd;

    private String rEventTypeDesc;

    private String sEventTitleUrl;

    private String sEventContentUrl;

    private String sEventSubContent1Url;

    private String sEventSubContent2Str;

    private Integer sEventActiveInd;

    private Date createTs;

    private Date updateTs;

    private String sEventSearchContentTxt;

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
    }

    public Integer getsEventCategoryCd() {
        return sEventCategoryCd;
    }

    public void setsEventCategoryCd(Integer sEventCategoryCd) {
        this.sEventCategoryCd = sEventCategoryCd;
    }

    public String getrEventCategoryDesc() {
        return rEventCategoryDesc;
    }

    public void setrEventCategoryDesc(String rEventCategoryDesc) {
        this.rEventCategoryDesc = rEventCategoryDesc;
    }

    public Integer getsEventTypeCd() {
        return sEventTypeCd;
    }

    public void setsEventTypeCd(Integer sEventTypeCd) {
        this.sEventTypeCd = sEventTypeCd;
    }

    public String getrEventTypeDesc() {
        return rEventTypeDesc;
    }

    public void setrEventTypeDesc(String rEventTypeDesc) {
        this.rEventTypeDesc = rEventTypeDesc;
    }

    public String getsEventTitleUrl() {
        return sEventTitleUrl;
    }

    public void setsEventTitleUrl(String sEventTitleUrl) {
        this.sEventTitleUrl = sEventTitleUrl;
    }

    public String getsEventContentUrl() {
        return sEventContentUrl;
    }

    public void setsEventContentUrl(String sEventContentUrl) {
        this.sEventContentUrl = sEventContentUrl;
    }

    public String getsEventSubContent1Url() {
        return sEventSubContent1Url;
    }

    public void setsEventSubContent1Url(String sEventSubContent1Url) {
        this.sEventSubContent1Url = sEventSubContent1Url;
    }

    public String getsEventSubContent2Str() {
        return sEventSubContent2Str;
    }

    public void setsEventSubContent2Str(String sEventSubContent2Str) {
        this.sEventSubContent2Str = sEventSubContent2Str;
    }

    public Integer getsEventActiveInd() {
        return sEventActiveInd;
    }

    public void setsEventActiveInd(Integer sEventActiveInd) {
        this.sEventActiveInd = sEventActiveInd;
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

    public String getsEventSearchContentTxt() {
        return sEventSearchContentTxt;
    }

    public void setsEventSearchContentTxt(String sEventSearchContentTxt) {
        this.sEventSearchContentTxt = sEventSearchContentTxt;
    }
}