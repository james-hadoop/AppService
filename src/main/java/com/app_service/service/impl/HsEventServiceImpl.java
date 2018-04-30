package com.app_service.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app_service.common.GlobalConstant;
import com.app_service.common.Response;
import com.app_service.dao.mapper.hs_event.HsEventMapper;
import com.app_service.dao.mapper.hs_event.SEventActiveMapper;
import com.app_service.dao.mapper.hs_event.SEventBannerMapper;
import com.app_service.dao.mapper.hs_event.SEventCategoryMapper;
import com.app_service.dao.mapper.hs_event.SEventContentMapper;
import com.app_service.dao.mapper.hs_event.SEventRecom1Mapper;
import com.app_service.dao.mapper.hs_event.SEventRecom2Mapper;
import com.app_service.dao.mapper.hs_event.SEventRecom3Mapper;
import com.app_service.dao.mapper.hs_event.SEventSubContent1Mapper;
import com.app_service.dao.mapper.hs_event.SEventSubContent2Mapper;
import com.app_service.dao.mapper.hs_event.SEventTypeMapper;
import com.app_service.dao.mapper.hs_event.TEventPageMapper;
import com.app_service.entity.enums.StatusEnum;
import com.app_service.entity.hs_event.HsEvent;
import com.app_service.entity.hs_event.SEventActive;
import com.app_service.entity.hs_event.SEventBanner;
import com.app_service.entity.hs_event.SEventCategory;
import com.app_service.entity.hs_event.SEventContent;
import com.app_service.entity.hs_event.SEventRecom1;
import com.app_service.entity.hs_event.SEventRecom2;
import com.app_service.entity.hs_event.SEventRecom3;
import com.app_service.entity.hs_event.SEventSubContent1;
import com.app_service.entity.hs_event.SEventSubContent2;
import com.app_service.entity.hs_event.SEventType;
import com.app_service.entity.hs_event.TEventPage;
import com.app_service.entity.hs_event.TEventSummary;
import com.app_service.service.IHsEventService;
import com.app_service.util.HsEventUtil;

@Service
public class HsEventServiceImpl implements IHsEventService {
    @Autowired
    TEventPageMapper tEventPageMapper;
    @Autowired
    HsEventMapper hsEventMapper;
    @Autowired
    SEventActiveMapper sEventActiveMapper;
    @Autowired
    SEventBannerMapper sEventBannerMapper;
    @Autowired
    SEventCategoryMapper sEventCategoryMapper;
    @Autowired
    SEventContentMapper sEventContentMapper;
    @Autowired
    SEventRecom1Mapper sEventRecom1Mapper;
    @Autowired
    SEventRecom2Mapper sEventRecom2Mapper;
    @Autowired
    SEventRecom3Mapper sEventRecom3Mapper;
    @Autowired
    SEventSubContent1Mapper sEventSubContent1Mapper;
    @Autowired
    SEventSubContent2Mapper sEventSubContent2Mapper;
    @Autowired
    SEventTypeMapper sEventTypeMapper;

    @Override
    public String checkUpdate(String eventVersion) {
        String currentEventVersion = GlobalConstant.getEVENT_VERSION();

        if (currentEventVersion.compareToIgnoreCase(eventVersion) > 0) {
            return currentEventVersion;
        } else {
            return eventVersion;
        }
    }

    @Override
    public List<TEventSummary> getTEventSummaryList(Map<String, Object> paramMap) {
        List<TEventPage> tEventPageList = tEventPageMapper.getTEventPageList(paramMap);
        List<TEventSummary> tEventSummaryList = HsEventUtil.eventPageList2EventSummaryList(tEventPageList);
        return tEventSummaryList;
    }

    @Override
    public int getTEventSummaryListCount(Map<String, Object> paramMap) {
        return tEventPageMapper.getTEventPageListCount(paramMap);
    }

    @Override
    public List<TEventSummary> getTEventSummaryByType(Map<String, Object> paramMap) {
        List<TEventPage> tEventPageList;

        Integer sEventTypeCd = (Integer) paramMap.get("sEventTypeCd");
        if (null == sEventTypeCd || -1 == sEventTypeCd) {
            tEventPageList = tEventPageMapper.getAllTEventPageList(paramMap);
        } else {
            switch (sEventTypeCd) {
            case 1:
                tEventPageList = tEventPageMapper.getTEventPageListForRecom1(paramMap);
                break;
            case 2:
                tEventPageList = tEventPageMapper.getTEventPageListForRecom2(paramMap);
                break;
            case 3:
                tEventPageList = tEventPageMapper.getTEventPageListForRecom3(paramMap);
                break;
            default:
                tEventPageList = tEventPageMapper.getAllTEventPageList(paramMap);
            }
        }

        List<TEventSummary> tEventSummaryList = HsEventUtil.eventPageList2EventSummaryList(tEventPageList);
        return tEventSummaryList;
    }

    @Override
    public int getTEventSummaryByTypeCount(Map<String, Object> paramMap) {
        Integer sEventTypeCd = (Integer) paramMap.get("sEventTypeCd");

        int count = 0;

        if (null == sEventTypeCd) {
            count = tEventPageMapper.getAllTEventPageListCount(paramMap);
        } else {
            switch (sEventTypeCd) {
            case 1:
                count = tEventPageMapper.getTEventPageListForRecom1Count(paramMap);
                break;
            case 2:
                count = tEventPageMapper.getTEventPageListForRecom2Count(paramMap);
                break;
            case 3:
                count = tEventPageMapper.getTEventPageListForRecom3Count(paramMap);
                break;
            default:
                count = tEventPageMapper.getAllTEventPageListCount(paramMap);
            }
        }

        return count;
    }

    @Override
    public List<TEventSummary> getTEventSummaryByCategory(Map<String, Object> paramMap) {
        Integer sEventCategoryCd = (Integer) paramMap.get("sEventCategoryCd");

        List<TEventPage> tEventPageList;

        if (null == sEventCategoryCd || -1 == sEventCategoryCd) {
            tEventPageList = tEventPageMapper.getAllTEventPageList(paramMap);
        } else {
            tEventPageList = tEventPageMapper.getTEventPageListByCategory(paramMap);
        }

        List<TEventSummary> tEventSummaryList = HsEventUtil.eventPageList2EventSummaryList(tEventPageList);
        return tEventSummaryList;
    }

    @Override
    public int getTEventSummaryByCategoryCount(Map<String, Object> paramMap) {
        Integer sEventCategoryCd = (Integer) paramMap.get("sEventCategoryCd");

        int count = 0;

        if (null == sEventCategoryCd || -1 == sEventCategoryCd) {
            count = tEventPageMapper.getAllTEventPageListCount(paramMap);
        } else {
            count = tEventPageMapper.getTEventPageListByCategoryCount(paramMap);
        }

        return count;
    }

    @Override
    public List<TEventSummary> getTEventPageListForBanner(Map<String, Object> paramMap) {
        List<TEventPage> tEventPageList = tEventPageMapper.getTEventPageListForBanner(paramMap);

        List<TEventSummary> tEventSummaryList = HsEventUtil.eventPageList2EventSummaryList(tEventPageList);
        return tEventSummaryList;
    }

    @Override
    public int getTEventPageListForBannerCount(Map<String, Object> paramMap) {
        int count = tEventPageMapper.getTEventPageListForBannerCount(paramMap);
        return count;
    }

    @Override
    public List<TEventSummary> getTEventSummaryByCondition(Map<String, Object> paramMap) {
        List<TEventPage> tEventPageList = tEventPageMapper.getTEventPageListByCondition(paramMap);

        List<TEventSummary> tEventSummaryList = HsEventUtil.eventPageList2EventSummaryList(tEventPageList);
        return tEventSummaryList;
    }

    @Override
    public int getTEventSummaryByConditionCount(Map<String, Object> paramMap) {
        return tEventPageMapper.getTEventPageListByConditionCount(paramMap);
    }

    @Override
    public List<TEventSummary> getTEventSummaryByConditionGlobal(Map<String, Object> paramMap) throws IOException {
        List<TEventSummary> tEventSummaryList = tEventPageMapper.getTEventSummaryByCondition(paramMap);

        for (TEventSummary event : tEventSummaryList) {
            List<SEventSubContent1> eventSubContent1List = sEventSubContent1Mapper
                    .getEventSubContent1ByEventId(event.gethEventId());
            List<SEventSubContent2> eventSubContent2List = sEventSubContent2Mapper
                    .getEventSubContent2ByEventId(event.gethEventId());

            event.setsEventSubContent(HsEventUtil.makeEventSubContent(eventSubContent1List, eventSubContent2List));
            event.setsEventSubContentString(
                    HsEventUtil.makeEventSubContentString(eventSubContent1List, eventSubContent2List));
        }

        return tEventSummaryList;
    }

    @Override
    public int getTEventSummaryByConditionGlobalCount(Map<String, Object> paramMap) {
        return tEventPageMapper.getTEventSummaryByConditionCount(paramMap);
    }

    @Override
    @Transactional
    public int addTEventSummary(TEventSummary tEventSummary) {
        Date timestamp = new Date();
        tEventSummary.setCreateTs(timestamp);
        tEventSummary.setUpdateTs(timestamp);

        // HsEvent
        HsEvent hsEvent = HsEventUtil.eventSummary2Event(tEventSummary);
        hsEventMapper.insertSelective(hsEvent);
        long eventId = hsEventMapper.getMaxHEventId();

        tEventSummary.sethEventId(eventId);
        tEventSummary.setsEventSearchContentTxt("?");

        // SEventActive
        SEventActive sEventActive = HsEventUtil.eventSummary2EventActive(tEventSummary);
        sEventActiveMapper.insertSelective(sEventActive);

        // SEventBanner
        SEventBanner sEventBanner = HsEventUtil.eventSummary2EventBanner(tEventSummary);
        sEventBannerMapper.insertSelective(sEventBanner);

        // SEventCategory
        SEventCategory sEventCategory = HsEventUtil.eventSummary2EventCategory(tEventSummary);
        sEventCategoryMapper.insertSelective(sEventCategory);

        // SEventType
        SEventType sEventType = HsEventUtil.eventSummary2EventType(tEventSummary);
        sEventTypeMapper.insertSelective(sEventType);

        // SEventContent
        SEventContent sEventContent = HsEventUtil.eventSummary2EventContent(tEventSummary);
        sEventContentMapper.insertSelective(sEventContent);

        // SEventRecom1
        SEventRecom1 sEventRecom1 = HsEventUtil.eventSummary2EventRecom1(tEventSummary);
        if (null != sEventRecom1) {
            sEventRecom1Mapper.insertSelective(sEventRecom1);
        }

        // SEventRecom2
        SEventRecom2 sEventRecom2 = HsEventUtil.eventSummary2EventRecom2(tEventSummary);
        if (null != sEventRecom2) {
            sEventRecom2Mapper.insertSelective(sEventRecom2);
        }

        // SEventRecom3
        SEventRecom3 sEventRecom3 = HsEventUtil.eventSummary2EventRecom3(tEventSummary);
        if (null != sEventRecom3) {
            sEventRecom3Mapper.insertSelective(sEventRecom3);
        }

        try {
            if (null != tEventSummary.getsEventSubContentString()
                    && 0 != tEventSummary.getsEventSubContentString().length()) {
                // SEventSubContent1
                List<SEventSubContent1> sEventSubContent1List = HsEventUtil
                        .eventSummary2EventSubContent1(tEventSummary);
                for (SEventSubContent1 record : sEventSubContent1List) {
                    sEventSubContent1Mapper.insertSelective(record);
                }

                // SEventSubContent2
                List<SEventSubContent2> sEventSubContent2List = HsEventUtil
                        .eventSummary2EventSubContent2(tEventSummary);
                if (null != sEventSubContent2List) {
                    for (SEventSubContent2 record : sEventSubContent2List) {
                        sEventSubContent2Mapper.insertSelective(record);
                    }
                }
            }

            // TEventPage
            List<TEventPage> tEventPageList = HsEventUtil.eventSummary2EventPageList(tEventSummary);
            if (null != tEventPageList && 0 < tEventPageList.size()) {
                tEventPageMapper.insertSelective(tEventPageList.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ERROR;
        }

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int editTEventSummary(TEventSummary tEventSummary) {
        Date timestamp = new Date();
        tEventSummary.setUpdateTs(timestamp);

        // HsEvent
        HsEvent hsEvent = HsEventUtil.eventSummary2Event(tEventSummary);
        hsEventMapper.updateByPrimaryKeySelective(hsEvent);

        // SEventActive
        SEventActive sEventActive = HsEventUtil.eventSummary2EventActive(tEventSummary);
        sEventActiveMapper.updateByPrimaryKeySelective(sEventActive);

        // SEventBanner
        SEventBanner sEventBanner = HsEventUtil.eventSummary2EventBanner(tEventSummary);
        sEventBannerMapper.updateByPrimaryKeySelective(sEventBanner);

        // SEventCategory
        SEventCategory sEventCategory = HsEventUtil.eventSummary2EventCategory(tEventSummary);
        sEventCategoryMapper.updateByPrimaryKeySelective(sEventCategory);

        // SEventType
        SEventType sEventType = HsEventUtil.eventSummary2EventType(tEventSummary);
        sEventTypeMapper.updateByPrimaryKeySelective(sEventType);

        // SEventContent
        SEventContent sEventContent = HsEventUtil.eventSummary2EventContent(tEventSummary);
        sEventContentMapper.updateByPrimaryKeySelective(sEventContent);

        // SEventRecom1
        SEventRecom1 sEventRecom1 = HsEventUtil.eventSummary2EventRecom1(tEventSummary);
        if (null != sEventRecom1) {
            sEventRecom1Mapper.updateByPrimaryKeySelective(sEventRecom1);
        }

        // SEventRecom2
        SEventRecom2 sEventRecom2 = HsEventUtil.eventSummary2EventRecom2(tEventSummary);
        if (null != sEventRecom2) {
            sEventRecom2Mapper.updateByPrimaryKeySelective(sEventRecom2);
        }

        // SEventRecom3
        SEventRecom3 sEventRecom3 = HsEventUtil.eventSummary2EventRecom3(tEventSummary);
        if (null != sEventRecom3) {
            sEventRecom3Mapper.updateByPrimaryKeySelective(sEventRecom3);
        }

        try {
            if (null != tEventSummary.getsEventSubContentString()
                    && 0 != tEventSummary.getsEventSubContentString().length()) {
                sEventSubContent1Mapper.deleteByEventId(tEventSummary.gethEventId());
                sEventSubContent2Mapper.deleteByEventId(tEventSummary.gethEventId());

                // SEventSubContent1
                List<SEventSubContent1> sEventSubContent1List = HsEventUtil
                        .eventSummary2EventSubContent1(tEventSummary);
                for (SEventSubContent1 record : sEventSubContent1List) {
                    sEventSubContent1Mapper.insertSelective(record);
                }

                // SEventSubContent2
                List<SEventSubContent2> sEventSubContent2List = HsEventUtil
                        .eventSummary2EventSubContent2(tEventSummary);
                if (null != sEventSubContent2List) {
                    for (SEventSubContent2 record : sEventSubContent2List) {
                        sEventSubContent2Mapper.insertSelective(record);
                    }
                }
            }

            // TEventPage
            List<TEventPage> tEventPageList = HsEventUtil.eventSummary2EventPageList(tEventSummary);
            for (TEventPage record : tEventPageList) {
                tEventPageMapper.updateByPrimaryKeySelective(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.ERROR;
        }

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int deleteTEventSummary(TEventSummary tEventSummary) {
        Date timestamp = new Date();
        tEventSummary.setUpdateTs(timestamp);
        tEventSummary.setsEventActiveInd(StatusEnum.Unactive.getCode());

        // SEventActive
        List<SEventActive> eventActiveList = sEventActiveMapper.selectByEventId(tEventSummary.gethEventId());
        for (SEventActive ea : eventActiveList) {
            ea.setsEventActiveInd(StatusEnum.Unactive.getCode());
            sEventActiveMapper.updateByPrimaryKeySelective(ea);
        }

        // TEventPage
        List<TEventPage> tEventPageList;
        try {
            tEventPageList = HsEventUtil.eventSummary2EventPageList(tEventSummary);

            for (TEventPage record : tEventPageList) {
                tEventPageMapper.updateByPrimaryKeySelective(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Response.ERROR;
        }

        return Response.SUCCESS;
    }

    @Override
    public List<SEventSubContent1> getEventSubContent1ByEventId(Long hEventId) {
        return sEventSubContent1Mapper.getEventSubContent1ByEventId(hEventId);
    }

    @Override
    public List<SEventSubContent2> getEventSubContent2ByEventId(Long hEventId) {
        return sEventSubContent2Mapper.getEventSubContent2ByEventId(hEventId);
    }
}