package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;

public class HsEventUtil {
    public static List<TEventPage> eventSummaryList2EventPageList(List<TEventSummary> eventSummaryList) {
        if (null == eventSummaryList || 0 == eventSummaryList.size()) {
            return null;
        }

        List<TEventPage> eventPageList = new ArrayList<TEventPage>();

        for (TEventSummary es : eventSummaryList) {
            eventPageList.addAll(eventSummary2EventPageList(es));
        }

        return eventPageList;
    }

    private static List<TEventPage> eventSummary2EventPageList(TEventSummary es) {
        if (null == es) {
            return null;
        }

        List<TEventPage> eventPageList = new ArrayList<TEventPage>();

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

            eventPageList.add(ep);
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

                eventPageList.add(ep);
            }
        }

        return eventPageList;
    }

    public static List<TEventSummary> eventPageList2EventSummaryList(List<TEventPage> eventPageList) {
        if (null == eventPageList || 0 == eventPageList.size()) {
            return null;
        }

        List<TEventSummary> eventSummaryList = new ArrayList<TEventSummary>();
        
        Set<Long> eventIdSet=new HashSet<Long>();
        
        for(TEventPage ep:eventPageList){
            Long eventId=ep.gethEventId();
            if(eventIdSet.contains(eventId)){
                
            }else{
                
            }
            
        }

        return eventSummaryList;
    }
}