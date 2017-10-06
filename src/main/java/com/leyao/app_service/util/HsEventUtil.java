package com.leyao.app_service.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.leyao.app_service.entity.hs_event.SubContentJsonEntity;
import com.leyao.app_service.entity.hs_event.SubContentJsonEntityWithoutUrl;
import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;
import com.leyao.app_service.entity.hs_event.enums.REventCategoryEnum;
import com.leyao.app_service.entity.hs_event.enums.REventTypeEnum;

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
            ep.setsEventCategoryCd(es.getsEventCategoryCd());
            ep.setrEventCategoryDesc(REventCategoryEnum.getValue(es.getsEventCategoryCd()));
            ep.setsEventTypeCd(es.getsEventTypeCd());
            ep.setrEventTypeDesc(REventTypeEnum.getValue(es.getsEventTypeCd()));
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
                ep.setsEventCategoryCd(es.getsEventCategoryCd());
                ep.setrEventCategoryDesc(REventCategoryEnum.getValue(es.getsEventCategoryCd()));
                ep.setsEventTypeCd(es.getsEventTypeCd());
                ep.setrEventTypeDesc(REventTypeEnum.getValue(es.getsEventTypeCd()));
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
                es.setsEventCategoryCd(ep.getsEventCategoryCd());
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
        if (es.getsEventTypeCd() == REventTypeEnum.Audio.getCode()) {
            sEventRecom1.setsEventRecomActiveInd(es.getsEventActiveInd());
            sEventRecom1.setsEventRecomPositionCd(es.getsEventRecomPositionCd());
        }
        sEventRecom1.setUpdateTs(es.getUpdateTs());

        return sEventRecom1;
    }

    public static SEventRecom2 eventSummary2EventRecom2(TEventSummary es) {
        SEventRecom2 sEventRecom2 = new SEventRecom2();
        sEventRecom2.setCreateTs(es.getCreateTs());
        sEventRecom2.sethEventId(es.gethEventId());
        if (es.getsEventTypeCd() == REventTypeEnum.Video.getCode()) {
            sEventRecom2.setsEventRecomActiveInd(es.getsEventActiveInd());
            sEventRecom2.setsEventRecomPositionCd(es.getsEventRecomPositionCd());
        }
        sEventRecom2.setUpdateTs(es.getUpdateTs());

        return sEventRecom2;
    }

    public static SEventRecom3 eventSummary2EventRecom3(TEventSummary es) {
        SEventRecom3 sEventRecom3 = new SEventRecom3();
        sEventRecom3.setCreateTs(es.getCreateTs());
        sEventRecom3.sethEventId(es.gethEventId());
        if (es.getsEventTypeCd() == REventTypeEnum.Image.getCode()) {
            sEventRecom3.setsEventRecomActiveInd(es.getsEventActiveInd());
            sEventRecom3.setsEventRecomPositionCd(es.getsEventRecomPositionCd());
        }
        sEventRecom3.setUpdateTs(es.getUpdateTs());

        return sEventRecom3;
    }

    public static List<SEventSubContent1> eventSummary2EventSubContent1(TEventSummary es) throws JsonParseException, JsonMappingException, IOException {
        if (null == es || null == es.getsEventSubContent() || 0 == es.getsEventSubContent().length()) {
            return null;
        }

        List<SubContentJsonEntity> entities = HsEventUtil.JsonString2SubContentJsonEntity(es.getsEventSubContent());

        List<SEventSubContent1> sEventSubContent1List = new ArrayList<SEventSubContent1>();
        for (SubContentJsonEntity entity : entities) {
            SEventSubContent1 sEventSubContent1 = new SEventSubContent1();
            sEventSubContent1.setCreateTs(es.getCreateTs());
            sEventSubContent1.sethEventId(es.gethEventId());
            sEventSubContent1.setsEventSubContent1Url(entity.getUrl());
            sEventSubContent1.setUpdateTs(es.getUpdateTs());

            sEventSubContent1List.add(sEventSubContent1);
        }

        return sEventSubContent1List;
    }

    public static List<SEventSubContent2> eventSummary2EventSubContent2(TEventSummary es) throws IOException {
        if (null == es || null == es.getsEventSubContent() || 0 == es.getsEventSubContent().length()) {
            return null;
        }

        List<SubContentJsonEntity> entities = HsEventUtil.JsonString2SubContentJsonEntity(es.getsEventSubContent());

        List<SEventSubContent2> sEventSubContent2List = new ArrayList<SEventSubContent2>();
        for (SubContentJsonEntity entity : entities) {
            SEventSubContent2 sEventSubContent2 = new SEventSubContent2();
            sEventSubContent2.setCreateTs(es.getCreateTs());
            sEventSubContent2.sethEventId(es.gethEventId());
            sEventSubContent2.setsEventSubContent2Str(HsEventUtil.SubContentJsonEntityWithoutUrl2JsonString(entity.toSubContentJsonEntityWithoutUrl()));
            sEventSubContent2.setUpdateTs(es.getUpdateTs());

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

    private static ObjectMapper mapper = new ObjectMapper();

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static String SubContentJsonEntity2JsonString(List<SubContentJsonEntity> entities) throws JsonProcessingException {
        String jsonString = mapper.writeValueAsString(entities);

        return jsonString;
    }

    public static List<SubContentJsonEntity> JsonString2SubContentJsonEntity(String json) throws JsonParseException, JsonMappingException, IOException {
        JavaType javaType = getCollectionType(ArrayList.class, SubContentJsonEntity.class);

        List<SubContentJsonEntity> entities = mapper.readValue(json, javaType);
        return entities;
    }

    public static String SubContentJsonEntityWithoutUrl2JsonString(SubContentJsonEntityWithoutUrl entity) throws JsonProcessingException {
        String convertedJobParam = mapper.writeValueAsString(entity);

        return convertedJobParam;
    }

    public static SubContentJsonEntityWithoutUrl JsonString2SubContentJsonEntityWithoutUrl(String json) throws JsonParseException, JsonMappingException, IOException {
        SubContentJsonEntityWithoutUrl entity = mapper.readValue(json, (new SubContentJsonEntityWithoutUrl().getClass()));
        return entity;
    }

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // String jsonOrigin =
        // "{\"url\":\"audio/a.mp3\",\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\"}";
        String jsonOrigin = "[{\"url\":\"audio/a.mp3\",\"lyricist\":\"peter\",\"composer\":\"tom\",\"singer\":\"linda\"},{\"url\":\"audio/b.mp3\",\"lyricist\":\"fang\",\"composer\":\"jay\",\"singer\":\"jay\"}]";

        List<SubContentJsonEntity> entities = HsEventUtil.JsonString2SubContentJsonEntity(jsonOrigin);
        System.out.println(entities.size());
        for (SubContentJsonEntity entity : entities) {
            System.out.println(entity.getUrl() + " " + entity.getSinger());
        }

        String jsonString = HsEventUtil.SubContentJsonEntity2JsonString(entities);
        System.out.println(jsonString);
    }
}