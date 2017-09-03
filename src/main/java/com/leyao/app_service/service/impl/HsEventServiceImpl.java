package com.leyao.app_service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.leyao.app_service.dao.mapper.hs_event.TEventPageMapper;
import com.leyao.app_service.entity.hs_event.TEventPage;
import com.leyao.app_service.entity.hs_event.TEventSummary;
import com.leyao.app_service.service.IHsEventService;
import com.leyao.app_service.util.HsEventUtil;

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
}