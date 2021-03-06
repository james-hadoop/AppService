package com.app_service.entity.hs_event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app_service.entity.hs_event.enums.REventCategoryEnum;
import com.app_service.entity.hs_event.enums.REventTypeEnum;
import com.app_service.util.DateUtil;

public class TEventSummary {
    private Long hEventId;

    private Integer sEventCategoryCd = 0;

    private String rEventCategoryDesc;

    private Integer sEventTypeCd = 0;

    private String rEventTypeDesc;

    private String sEventTitleUrl;

    private String sEventContentUrl;

    private Integer sEventActiveInd = 0;

    private Date createTs;

    private String createTsString;

    private Date updateTs;

    private String updateTsString;

    private String sEventSearchContentTxt = "?";

    private List<String> sEventSubContent1UrlList = new ArrayList<String>();

    private List<String> sEventSubContent2StrList = new ArrayList<String>();

    private List<SubContentJsonEntity> sEventSubContent = new ArrayList<SubContentJsonEntity>();

    private String sEventSubContentString = null;

    private Integer sEventBannerPositionCd = -1;

    private Integer sEventRecomPositionCd = 0;

    private Integer sEventRecom1PositionCd = 0;

    private Integer sEventRecom2PositionCd = 0;

    private Integer sEventRecom3PositionCd = 0;

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
        return REventCategoryEnum.getValue(sEventCategoryCd);
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
        return REventTypeEnum.getValue(sEventTypeCd);
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

    public List<SubContentJsonEntity> getsEventSubContent() {
        return sEventSubContent;
    }

    public void setsEventSubContent(List<SubContentJsonEntity> sEventSubContent) {
        this.sEventSubContent = sEventSubContent;
    }

    public String getsEventSubContentString() {
        return sEventSubContentString;
    }

    public void setsEventSubContentString(String sEventSubContentString) {
        this.sEventSubContentString = sEventSubContentString;
    }

    public Integer getsEventBannerPositionCd() {
        return sEventBannerPositionCd;
    }

    public void setsEventBannerPositionCd(Integer sEventBannerPositionCd) {
        this.sEventBannerPositionCd = sEventBannerPositionCd;
    }
    
    public Integer getsEventRecomPositionCd(boolean ignore) {
        return sEventRecomPositionCd;
    }

    public Integer getsEventRecomPositionCd() {
        switch (sEventTypeCd) {
        case 1: {
            return sEventRecom1PositionCd;
        }
        case 2: {
            return sEventRecom2PositionCd;
        }
        case 3: {
            return sEventRecom3PositionCd;
        }
        default: {
            return sEventRecomPositionCd;
        }
        }
    }

    public void setsEventRecomPositionCd(Integer sEventRecomPositionCd) {
        this.sEventRecomPositionCd = sEventRecomPositionCd;
    }

    public String getCreateTsString() {
        return DateUtil.DateToString(createTs);
    }

    public void setCreateTsString(String createTsString) {
        this.createTsString = createTsString;
    }

    public String getUpdateTsString() {
        return DateUtil.DateToString(updateTs);
    }

    public void setUpdateTsString(String updateTsString) {
        this.updateTsString = updateTsString;
    }

    public Integer getsEventRecom1PositionCd() {
        return sEventRecom1PositionCd;
    }

    public void setsEventRecom1PositionCd(Integer sEventRecom1PositionCd) {
        this.sEventRecom1PositionCd = sEventRecom1PositionCd;
    }

    public Integer getsEventRecom2PositionCd() {
        return sEventRecom2PositionCd;
    }

    public void setsEventRecom2PositionCd(Integer sEventRecom2PositionCd) {
        this.sEventRecom2PositionCd = sEventRecom2PositionCd;
    }

    public Integer getsEventRecom3PositionCd() {
        return sEventRecom3PositionCd;
    }

    public void setsEventRecom3PositionCd(Integer sEventRecom3PositionCd) {
        this.sEventRecom3PositionCd = sEventRecom3PositionCd;
    }
}