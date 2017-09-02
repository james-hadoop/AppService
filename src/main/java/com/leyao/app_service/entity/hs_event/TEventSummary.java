package com.leyao.app_service.entity.hs_event;

import java.util.Date;
import java.util.List;

public class TEventSummary {
    private Long sEventContentId;

    private Long hEventId;

    private String sEventTitleUrl;

    private String sEventContentUrl;

    private Date createTs;

    private Date updateTs;

    private Integer sEventPositionCd;

    private Integer sEventActiveInd;

    private Integer sEventCategoryCd;

    private Integer sEventTypeCd;

    private List<String> sEventSubContent1UrlList;

    private List<String> sEventSubContent2StrList;

    public Long getsEventContentId() {
        return sEventContentId;
    }

    public void setsEventContentId(Long sEventContentId) {
        this.sEventContentId = sEventContentId;
    }

    public Long gethEventId() {
        return hEventId;
    }

    public void sethEventId(Long hEventId) {
        this.hEventId = hEventId;
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

    public Integer getsEventPositionCd() {
        return sEventPositionCd;
    }

    public void setsEventPositionCd(Integer sEventPositionCd) {
        this.sEventPositionCd = sEventPositionCd;
    }

    public Integer getsEventActiveInd() {
        return sEventActiveInd;
    }

    public void setsEventActiveInd(Integer sEventActiveInd) {
        this.sEventActiveInd = sEventActiveInd;
    }

    public Integer getsEventCategoryCd() {
        return sEventCategoryCd;
    }

    public void setsEventCategoryCd(Integer sEventCategoryCd) {
        this.sEventCategoryCd = sEventCategoryCd;
    }

    public Integer getsEventTypeCd() {
        return sEventTypeCd;
    }

    public void setsEventTypeCd(Integer sEventTypeCd) {
        this.sEventTypeCd = sEventTypeCd;
    }

    public List<String> getsEventSubContent1UrlList() {
        return sEventSubContent1UrlList;
    }

    public void setsEventSubContent1UrlList(List<String> sEventSubContent1UrlList) {
        this.sEventSubContent1UrlList = sEventSubContent1UrlList;
    }

    public List<String> getsEventSubContent2StrList() {
        return sEventSubContent2StrList;
    }

    public void setsEventSubContent2StrList(List<String> sEventSubContent2StrList) {
        this.sEventSubContent2StrList = sEventSubContent2StrList;
    }
}