package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.leyao.app_service.common.GlobalConstant;
import com.leyao.app_service.entity.hs_event.HsEvent;
import com.leyao.app_service.entity.hs_event.SEventActive;
import com.leyao.app_service.entity.hs_event.SEventBanner;
import com.leyao.app_service.entity.hs_event.SEventCategory;
import com.leyao.app_service.entity.hs_event.SEventContent;
import com.leyao.app_service.entity.hs_event.SEventRecom1;
import com.leyao.app_service.entity.hs_event.SEventRecom2;
import com.leyao.app_service.entity.hs_event.SEventRecom3;
import com.leyao.app_service.entity.hs_event.SEventSubContent1;
import com.leyao.app_service.entity.hs_event.SEventSubContent2;
import com.leyao.app_service.entity.hs_event.SEventType;
import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;

public class HsEventUtil {
    public static List<TEventPage> eventSummaryList2EventPageList(List<TEventSummary> tEventSummaryList) {
        if (null == tEventSummaryList || 0 == tEventSummaryList.size()) {
            return null;
        }

        List<TEventPage> tEventPageList = new ArrayList<TEventPage>();

        for (TEventSummary es : tEventSummaryList) {
            tEventPageList.addAll(eventSummary2EventPageList(es));
        }

        return tEventPageList;
    }

    public static List<TEventPage> eventSummary2EventPageList(TEventSummary es) {
        if (null == es) {
            return null;
        }

        List<TEventPage> tEventPageList = new ArrayList<TEventPage>();

        List<String> subContent1Url = es.getsEventSubContent1UrlList();
        List<String> subContent2Str = es.getsEventSubContent2StrList();

        if (null == subContent1Url || 0 == subContent1Url.size()) {
            TEventPage ep = new TEventPage();

            ep.sethEventId(es.gethEventId());
            ep.setsEventCategoryCd(es.getsEventActiveInd());
            ep.setrEventCategoryDesc(es.getrEventCategoryDesc());
            ep.setsEventTypeCd(es.getsEventTypeCd());
            ep.setrEventTypeDesc(es.getrEventTypeDesc());
            ep.setsEventTitleUrl(es.getsEventTitleUrl());
            ep.setsEventContentUrl(es.getsEventContentUrl());
            ep.setsEventActiveInd(es.getsEventActiveInd());
            ep.setCreateTs(es.getCreateTs());
            ep.setUpdateTs(es.getUpdateTs());
            ep.setsEventSearchContentTxt(es.getsEventSearchContentTxt());

            tEventPageList.add(ep);
        } else {
            for (int i = 0; i < subContent1Url.size(); i++) {
                TEventPage ep = new TEventPage();

                ep.sethEventId(es.gethEventId());
                ep.setsEventCategoryCd(es.getsEventActiveInd());
                ep.setrEventCategoryDesc(es.getrEventCategoryDesc());
                ep.setsEventTypeCd(es.getsEventTypeCd());
                ep.setrEventTypeDesc(es.getrEventTypeDesc());
                ep.setsEventTitleUrl(es.getsEventTitleUrl());
                ep.setsEventContentUrl(es.getsEventContentUrl());
                ep.setsEventSubContent1Url(subContent1Url.get(i));
                ep.setsEventSubContent2Str(subContent2Str.get(i));
                ep.setsEventActiveInd(es.getsEventActiveInd());
                ep.setCreateTs(es.getCreateTs());
                ep.setUpdateTs(es.getUpdateTs());
                ep.setsEventSearchContentTxt(es.getsEventSearchContentTxt());

                tEventPageList.add(ep);
            }
        }

        return tEventPageList;
    }

    public static List<TEventSummary> eventPageList2EventSummaryList(List<TEventPage> tEventPageList) {
        if (null == tEventPageList || 0 == tEventPageList.size()) {
            return null;
        }

        List<TEventSummary> tEventSummaryList = new ArrayList<TEventSummary>();

        Set<Long> eventIdSet = new HashSet<Long>();

        java.util.Collections.sort(tEventPageList, null);
        // for (TEventPage ep : tEventPageList) {
        // System.out.print(ep.gethEventId());
        // }

        TEventSummary es = null;
        for (TEventPage ep : tEventPageList) {
            Long eventId = ep.gethEventId();

            if (eventIdSet.contains(eventId)) {
                String sEventSubContent1Url = ep.getsEventSubContent1Url();
                if (null != sEventSubContent1Url && !GlobalConstant.NULL_STRING.equals(sEventSubContent1Url)) {
                    es.getsEventSubContent1UrlList().add(sEventSubContent1Url);
                }

                String sEventSubContent2Str = ep.getsEventSubContent2Str();
                if (null != sEventSubContent2Str && !GlobalConstant.NULL_STRING.equals(sEventSubContent2Str)) {
                    es.getsEventSubContent2StrList().add(sEventSubContent2Str);
                }
            } else {
                eventIdSet.add(eventId);
                
                if (null != es) {
                    tEventSummaryList.add(es);
                }

                es = new TEventSummary();

                es.sethEventId(ep.gethEventId());
                es.setsEventCategoryCd(ep.getsEventActiveInd());
                es.setrEventCategoryDesc(ep.getrEventCategoryDesc());
                es.setsEventTypeCd(ep.getsEventTypeCd());
                es.setrEventTypeDesc(ep.getrEventTypeDesc());
                es.setsEventTitleUrl(ep.getsEventTitleUrl());
                es.setsEventContentUrl(ep.getsEventContentUrl());

                String sEventSubContent1Url = ep.getsEventSubContent1Url();
                if (null != sEventSubContent1Url && !GlobalConstant.NULL_STRING.equals(sEventSubContent1Url)) {
                    es.getsEventSubContent1UrlList().add(sEventSubContent1Url);
                }

                String sEventSubContent2Str = ep.getsEventSubContent2Str();
                if (null != sEventSubContent2Str && !GlobalConstant.NULL_STRING.equals(sEventSubContent2Str)) {
                    es.getsEventSubContent2StrList().add(sEventSubContent2Str);
                }

                es.setsEventActiveInd(ep.getsEventActiveInd());
                es.setCreateTs(ep.getCreateTs());
                es.setUpdateTs(ep.getUpdateTs());
                es.setsEventSearchContentTxt(ep.getsEventSearchContentTxt());
            }
        }

        if (null != es) {
            tEventSummaryList.add(es);
        }

        return tEventSummaryList;
    }

    public static HsEvent eventSummary2Event(TEventSummary es) {
        HsEvent event = new HsEvent();
        event.sethEventId(es.gethEventId());
        event.setCreateTs(es.getCreateTs());
        event.sethEventId(es.gethEventId());
        event.setUpdateTs(es.getUpdateTs());

        return event;
    }

    public static SEventActive eventSummary2EventActive(TEventSummary es) {
        SEventActive eventActive = new SEventActive();
        eventActive.sethEventId(es.gethEventId());
        eventActive.setCreateTs(es.getCreateTs());
        eventActive.sethEventId(es.gethEventId());
        eventActive.setsEventActiveInd(es.getsEventActiveInd());
        eventActive.setUpdateTs(es.getUpdateTs());

        return eventActive;
    }

    public static SEventBanner eventSummary2EventBanner(TEventSummary es) {
        SEventBanner sEventBanner = new SEventBanner();
        sEventBanner.setCreateTs(es.getCreateTs());
        sEventBanner.sethEventId(es.gethEventId());
        sEventBanner.setsEventBannerActiveInd(es.getsEventActiveInd());
        sEventBanner.setsEventBannerPositionCd(es.getsEventBannerPositionCd());
        sEventBanner.setUpdateTs(es.getUpdateTs());

        return sEventBanner;
    }

    public static SEventCategory eventSummary2EventCategory(TEventSummary es) {
        SEventCategory sEventCategory = new SEventCategory();
        sEventCategory.setCreateTs(es.getCreateTs());
        sEventCategory.sethEventId(es.gethEventId());
        sEventCategory.setsEventCategoryCd(es.getsEventCategoryCd());
        sEventCategory.setUpdateTs(es.getUpdateTs());

        return sEventCategory;
    }

    public static SEventContent eventSummary2EventContent(TEventSummary es) {
        SEventContent sEventContent = new SEventContent();
        sEventContent.setCreateTs(es.getCreateTs());
        sEventContent.sethEventId(es.gethEventId());
        sEventContent.setsEventContentUrl(es.getsEventContentUrl());
        sEventContent.setsEventTitleUrl(es.getsEventTitleUrl());
        sEventContent.setUpdateTs(es.getUpdateTs());

        return sEventContent;
    }

    public static SEventRecom1 eventSummary2EventRecom1(TEventSummary es) {
        SEventRecom1 sEventRecom1 = new SEventRecom1();
        sEventRecom1.setCreateTs(es.getCreateTs());
        sEventRecom1.sethEventId(es.gethEventId());
        sEventRecom1.setsEventRecomActiveInd(es.getsEventActiveInd());
        sEventRecom1.setsEventRecomPositionCd(es.getsEventRecomPositionCd());
        sEventRecom1.setUpdateTs(es.getUpdateTs());

        return sEventRecom1;
    }

    public static SEventRecom2 eventSummary2EventRecom2(TEventSummary es) {
        SEventRecom2 sEventRecom2 = new SEventRecom2();
        sEventRecom2.setCreateTs(es.getCreateTs());
        sEventRecom2.sethEventId(es.gethEventId());
        sEventRecom2.setsEventRecomActiveInd(es.getsEventActiveInd());
        sEventRecom2.setsEventRecomPositionCd(es.getsEventRecomPositionCd());
        sEventRecom2.setUpdateTs(es.getUpdateTs());

        return sEventRecom2;
    }

    public static SEventRecom3 eventSummary2EventRecom3(TEventSummary es) {
        SEventRecom3 sEventRecom3 = new SEventRecom3();
        sEventRecom3.setCreateTs(es.getCreateTs());
        sEventRecom3.sethEventId(es.gethEventId());
        sEventRecom3.setsEventRecomActiveInd(es.getsEventActiveInd());
        sEventRecom3.setsEventRecomPositionCd(es.getsEventRecomPositionCd());
        sEventRecom3.setUpdateTs(es.getUpdateTs());

        return sEventRecom3;
    }

    public static List<SEventSubContent1> eventSummary2EventSubContent1(TEventSummary es) {
        List<TEventPage> tEventPageList = eventSummary2EventPageList(es);
        if (null == tEventPageList || 0 == tEventPageList.size()) {
            return null;
        }

        List<SEventSubContent1> sEventSubContent1List = new ArrayList<SEventSubContent1>();
        for (TEventPage tEventPage : tEventPageList) {
            SEventSubContent1 sEventSubContent1 = new SEventSubContent1();
            sEventSubContent1.setCreateTs(tEventPage.getCreateTs());
            sEventSubContent1.sethEventId(tEventPage.gethEventId());
            sEventSubContent1.setsEventSubContent1Url(tEventPage.getsEventSubContent1Url());
            sEventSubContent1.setUpdateTs(tEventPage.getUpdateTs());

            sEventSubContent1List.add(sEventSubContent1);
        }

        return sEventSubContent1List;
    }

    public static List<SEventSubContent2> eventSummary2EventSubContent2(TEventSummary es) {
        List<TEventPage> tEventPageList = eventSummary2EventPageList(es);
        if (null == tEventPageList || 0 == tEventPageList.size()) {
            return null;
        }

        List<SEventSubContent2> sEventSubContent2List = new ArrayList<SEventSubContent2>();
        for (TEventPage tEventPage : tEventPageList) {
            SEventSubContent2 sEventSubContent2 = new SEventSubContent2();
            sEventSubContent2.setCreateTs(tEventPage.getCreateTs());
            sEventSubContent2.sethEventId(tEventPage.gethEventId());
            sEventSubContent2.setsEventSubContent2Str(tEventPage.getsEventSubContent2Str());
            sEventSubContent2.setUpdateTs(tEventPage.getUpdateTs());

            sEventSubContent2List.add(sEventSubContent2);
        }

        return sEventSubContent2List;
    }

    public static SEventType eventSummary2EventType(TEventSummary es) {
        SEventType sEventType = new SEventType();
        sEventType.setCreateTs(es.getCreateTs());
        sEventType.sethEventId(es.gethEventId());
        sEventType.setsEventTypeCd(es.getsEventTypeCd());
        sEventType.setUpdateTs(es.getUpdateTs());

        return sEventType;
    }
}