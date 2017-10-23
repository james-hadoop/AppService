package com.app_service.util;

import com.app_service.entity.ls_user_event.LUserEvent;
import com.app_service.entity.ls_user_event.SUserEventActive;
import com.app_service.entity.ls_user_event.SUserEventLike;
import com.app_service.entity.ls_user_event.SUserEventRead;
import com.app_service.entity.ls_user_event.TUserEventSummary;

public class LsUserEventUtil {
    public static LUserEvent userEventSummary2UserEvent(TUserEventSummary tUserEventSummary) {
        LUserEvent lUserEvent = new LUserEvent();
        lUserEvent.setCreateTs(tUserEventSummary.getCreateTs());
        lUserEvent.setlUserEventId(tUserEventSummary.getlUserEventId());
        lUserEvent.sethEventId(tUserEventSummary.gethEventId());
        lUserEvent.setUpdateTs(tUserEventSummary.getUpdateTs());

        return lUserEvent;
    }

    public static SUserEventActive userEventSummary2UserEventActive(TUserEventSummary tUserEventSummary) {
        SUserEventActive sUserEventActive = new SUserEventActive();
        sUserEventActive.setCreateTs(tUserEventSummary.getCreateTs());
        sUserEventActive.setlUserEventId(tUserEventSummary.getlUserEventId());
        sUserEventActive.setsUserEventActiveInd(tUserEventSummary.getsUserEventActiveInd());
        sUserEventActive.setsUserEventActiveId(tUserEventSummary.getlUserEventId());
        sUserEventActive.setUpdateTs(tUserEventSummary.getUpdateTs());

        return sUserEventActive;
    }

    public static SUserEventLike userEventSummary2UserEventLike(TUserEventSummary tUserEventSummary) {
        SUserEventLike sUserEventLike = new SUserEventLike();
        sUserEventLike.setCreateTs(tUserEventSummary.getCreateTs());
        sUserEventLike.setlUserEventId(tUserEventSummary.getlUserEventId());
        sUserEventLike.setsUserEventLikeInd(tUserEventSummary.getsUserEventLikeInd());
        sUserEventLike.setUpdateTs(tUserEventSummary.getUpdateTs());

        return sUserEventLike;
    }

    public static SUserEventRead userEventSummary2UserEventRead(TUserEventSummary tUserEventSummary) {
        SUserEventRead sUserEventRead = new SUserEventRead();
        sUserEventRead.setCreateTs(tUserEventSummary.getCreateTs());
        sUserEventRead.setlUserEventId(tUserEventSummary.getlUserEventId());
        sUserEventRead.setsUserEventReadLogTxt(tUserEventSummary.getsUserEventReadLogTxt());
        sUserEventRead.setUpdateTs(tUserEventSummary.getUpdateTs());

        return sUserEventRead;
    }
}