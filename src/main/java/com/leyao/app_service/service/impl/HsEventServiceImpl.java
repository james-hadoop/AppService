package com.leyao.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.dao.mapper.hs_event.TEventPageMapper;
import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;
import com.leyao.app_service.service.IHsEventService;
import com.leyao.app_service.util.HsEventUtil;

@Service
public class HsEventServiceImpl implements IHsEventService {
    @Autowired
    TEventPageMapper tEventPageMapper;

    @Override
    public String checkUpdate() {
        // TODO Auto-generated method stub
        return null;
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
    }

    @Override
    public List<TEventSummary> getTEventSummary(Map<String, Object> paramMap) {
        List<TEventPage> tEventPageList;

        Integer sEventTypeCd = (Integer) paramMap.get("sEventTypeCd");
        if (null == sEventTypeCd) {
            tEventPageList = tEventPageMapper.getTEventPageListForNoRecom(paramMap);
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
                tEventPageList = tEventPageMapper.getTEventPageListForNoRecom(paramMap);
            }
        }

        List<TEventSummary> tEventSummaryList = HsEventUtil.eventPageList2EventSummaryList(tEventPageList);
        return tEventSummaryList;
    }

    @Override
    public int getTEventSummaryCount(Map<String, Object> paramMap) {
        Integer sEventTypeCd = (Integer) paramMap.get("sEventTypeCd");

        int count = 0;

        if (null == sEventTypeCd) {
            count = tEventPageMapper.getTEventPageListForNoRecomCount(paramMap);
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
                count = tEventPageMapper.getTEventPageListForNoRecomCount(paramMap);
            }
        }

        return count;
    }
}