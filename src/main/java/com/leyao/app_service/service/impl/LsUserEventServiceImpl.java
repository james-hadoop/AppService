package com.leyao.app_service.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.leyao.app_service.dao.mapper.ls_user_event.LUserEventMapper;
import com.leyao.app_service.dao.mapper.ls_user_event.SUserEventActiveMapper;
import com.leyao.app_service.dao.mapper.ls_user_event.SUserEventLikeMapper;
import com.leyao.app_service.dao.mapper.ls_user_event.SUserEventReadMapper;
import com.leyao.app_service.entity.ls_user_event.LUserEvent;
import com.leyao.app_service.entity.ls_user_event.SUserEventActive;
import com.leyao.app_service.entity.ls_user_event.SUserEventLike;
import com.leyao.app_service.entity.ls_user_event.SUserEventRead;
import com.leyao.app_service.entity.ls_user_event.TUserEventSummary;
import com.leyao.app_service.service.ILsUserEventService;
import com.leyao.app_service.util.LsUserEventUtil;

public class LsUserEventServiceImpl implements ILsUserEventService {
    @Autowired
    LUserEventMapper lUserEventMapper;

    @Autowired
    SUserEventActiveMapper sUserEventActiveMapper;

    @Autowired
    SUserEventLikeMapper sUserEventLikeMapper;

    @Autowired
    SUserEventReadMapper sUserEventReadMapper;

    @Override
    public int feedbackTUserEventSummary(TUserEventSummary tUserEventSummary) {
        Date timestamp = new Date();
        tUserEventSummary.setCreateTs(timestamp);
        tUserEventSummary.setUpdateTs(timestamp);

        // LUserEvent
        LUserEvent lUserEvent = LsUserEventUtil.userEventSummary2UserEvent(tUserEventSummary);
        lUserEventMapper.insertSelective(lUserEvent);
        long lUserEventId = lUserEventMapper.getMaxLUserEventId();

        tUserEventSummary.setlUserEventId(lUserEventId);

        // SUserEventActive
        SUserEventActive sUserEventActive = LsUserEventUtil.userEventSummary2UserEventActive(tUserEventSummary);
        sUserEventActiveMapper.insertSelective(sUserEventActive);

        // SUserEventLike
        SUserEventLike sUserEventLike = LsUserEventUtil.userEventSummary2UserEventLike(tUserEventSummary);
        sUserEventLikeMapper.insertSelective(sUserEventLike);

        // SUserEventRead
        SUserEventRead sUserEventRead = LsUserEventUtil.userEventSummary2UserEventRead(tUserEventSummary);
        sUserEventReadMapper.insertSelective(sUserEventRead);

        return 0;
    }

}
