package com.leyao.app_service.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leyao.app_service.common.GlobalConstant;
import com.leyao.app_service.common.Response;
import com.leyao.app_service.dao.mapper.hs_event.HsEventMapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventActiveMapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventBannerMapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventCategoryMapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventContentMapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventRecom1Mapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventRecom2Mapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventRecom3Mapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventSubContent1Mapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventSubContent2Mapper;
import com.leyao.app_service.dao.mapper.hs_event.SEventTypeMapper;
import com.leyao.app_service.dao.mapper.hs_event.TEventPageMapper;
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
import com.leyao.app_service.entity.hs_event.enums.REventActiveEnum;
import com.leyao.app_service.service.IHsEventService;
import com.leyao.app_service.util.HsEventUtil;

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

        // SEventContent
        SEventContent sEventContent = HsEventUtil.eventSummary2EventContent(tEventSummary);
        sEventContentMapper.insertSelective(sEventContent);

        // SEventRecom1
        SEventRecom1 sEventRecom1 = HsEventUtil.eventSummary2EventRecom1(tEventSummary);
        sEventRecom1Mapper.insertSelective(sEventRecom1);

        // SEventRecom2
        SEventRecom2 sEventRecom2 = HsEventUtil.eventSummary2EventRecom2(tEventSummary);
        sEventRecom2Mapper.insertSelective(sEventRecom2);

        // SEventRecom3
        SEventRecom3 sEventRecom3 = HsEventUtil.eventSummary2EventRecom3(tEventSummary);
        sEventRecom3Mapper.insertSelective(sEventRecom3);

        if (null != tEventSummary.getsEventSubContent() && 0 != tEventSummary.getsEventSubContent().length()) {
            try {
                // SEventSubContent1
                List<SEventSubContent1> sEventSubContent1List = HsEventUtil.eventSummary2EventSubContent1(tEventSummary);
                for (SEventSubContent1 record : sEventSubContent1List) {
                    sEventSubContent1Mapper.insertSelective(record);
                }

                // SEventSubContent2
                List<SEventSubContent2> sEventSubContent2List = HsEventUtil.eventSummary2EventSubContent2(tEventSummary);
                for (SEventSubContent2 record : sEventSubContent2List) {
                    sEventSubContent2Mapper.insertSelective(record);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Response.ERROR;
            }
        }

        // SEventType
        SEventType sEventType = HsEventUtil.eventSummary2EventType(tEventSummary);
        sEventTypeMapper.insertSelective(sEventType);

        // TEventPage
        List<TEventPage> tEventPageList = HsEventUtil.eventSummary2EventPageList(tEventSummary);
        for (TEventPage record : tEventPageList) {
            tEventPageMapper.insertSelective(record);
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

        // SEventContent
        SEventContent sEventContent = HsEventUtil.eventSummary2EventContent(tEventSummary);
        sEventContentMapper.updateByPrimaryKeySelective(sEventContent);

        // SEventRecom1
        SEventRecom1 sEventRecom1 = HsEventUtil.eventSummary2EventRecom1(tEventSummary);
        sEventRecom1Mapper.updateByPrimaryKeySelective(sEventRecom1);

        // SEventRecom2
        SEventRecom2 sEventRecom2 = HsEventUtil.eventSummary2EventRecom2(tEventSummary);
        sEventRecom2Mapper.updateByPrimaryKeySelective(sEventRecom2);

        // SEventRecom3
        SEventRecom3 sEventRecom3 = HsEventUtil.eventSummary2EventRecom3(tEventSummary);
        sEventRecom3Mapper.updateByPrimaryKeySelective(sEventRecom3);

        if (null != tEventSummary.getsEventSubContent() && 0 != tEventSummary.getsEventSubContent().length()) {
            try {
                // SEventSubContent1
                List<SEventSubContent1> sEventSubContent1List = HsEventUtil.eventSummary2EventSubContent1(tEventSummary);
                for (SEventSubContent1 record : sEventSubContent1List) {
                    sEventSubContent1Mapper.insertSelective(record);
                }

                // SEventSubContent2
                List<SEventSubContent2> sEventSubContent2List = HsEventUtil.eventSummary2EventSubContent2(tEventSummary);
                for (SEventSubContent2 record : sEventSubContent2List) {
                    sEventSubContent2Mapper.insertSelective(record);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Response.ERROR;
            }
        }

        // SEventType
        SEventType sEventType = HsEventUtil.eventSummary2EventType(tEventSummary);
        sEventTypeMapper.updateByPrimaryKeySelective(sEventType);

        // TEventPage
        List<TEventPage> tEventPageList = HsEventUtil.eventSummary2EventPageList(tEventSummary);
        for (TEventPage record : tEventPageList) {
            tEventPageMapper.updateByPrimaryKeySelective(record);
        }

        return Response.SUCCESS;
    }

    @Override
    @Transactional
    public int deleteTEventSummary(TEventSummary tEventSummary) {
        Date timestamp = new Date();
        tEventSummary.setUpdateTs(timestamp);
        tEventSummary.setsEventActiveInd(REventActiveEnum.Unactive.getCode());

        // SEventActive
        List<SEventActive> eventActiveList = sEventActiveMapper.selectByEventId(tEventSummary.gethEventId());
        for (SEventActive ea : eventActiveList) {
            ea.setsEventActiveInd(REventActiveEnum.Unactive.getCode());
            sEventActiveMapper.updateByPrimaryKeySelective(ea);
        }

        // TEventPage
        List<TEventPage> tEventPageList = HsEventUtil.eventSummary2EventPageList(tEventSummary);
        for (TEventPage record : tEventPageList) {
            tEventPageMapper.updateByPrimaryKeySelective(record);
        }

        return Response.SUCCESS;
    }
}