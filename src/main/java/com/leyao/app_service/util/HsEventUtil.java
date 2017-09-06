package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.leyao.app_service.common.GlobalConstant;
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

    private static List<TEventPage> eventSummary2EventPageList(TEventSummary es) {
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
}