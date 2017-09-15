package com.leyao.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.common.GlobalConstant;
import com.leyao.app_service.common.Response;
import com.leyao.app_service.dao.mapper.hs_event.HsEventMapper;
import com.leyao.app_service.dao.mapper.hs_event.TEventPageMapper;
import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;
import com.leyao.app_service.service.IHsEventService;
import com.leyao.app_service.util.HsEventUtil;

@Service
public class HsEventServiceImpl implements IHsEventService {
    @Autowired
    TEventPageMapper tEventPageMapper;

    @Autowired
    HsEventMapper hsEventMapper;

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
    public void createHsEvent(TEventSummary record) {
        // TODO

        String currentEventVersion = hsEventMapper.checkUpdate().toString();
        GlobalConstant.setEVENT_VERSION(currentEventVersion);
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
    public int postTEventSummary(TEventSummary tEventSummary) {
        // TODO Auto-generated method stub
        Long hEventId=tEventSummary.gethEventId();
        if(null==hEventId){
            return Response.ERROR;
        }
        
        
        return Response.SUCCESS;
    }
}