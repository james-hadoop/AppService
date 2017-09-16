package com.leyao.app_service.util;

import com.leyao.app_service.entity.ls_user_message.LUserMessage;
import com.leyao.app_service.entity.ls_user_message.SUserMessageActive;
import com.leyao.app_service.entity.ls_user_message.TUserMessageSummary;

public class LsUserEventUtil {
    public static LUserMessage userMessageSummary2UserMessage(TUserMessageSummary tUserMessageSummary) {
        LUserMessage lUserMessage = new LUserMessage();
        lUserMessage.setCreateTs(tUserMessageSummary.getCreateTs());
        lUserMessage.sethMessageId(tUserMessageSummary.gethMessageId());
        lUserMessage.sethUserId(tUserMessageSummary.gethUserId());
        lUserMessage.setUpdateTs(tUserMessageSummary.getUpdateTs());

        return lUserMessage;
    }

    public static SUserMessageActive userMessageSummary2UserMessageActive(TUserMessageSummary tUserMessageSummary) {
        SUserMessageActive sUserMessageActive = new SUserMessageActive();
        sUserMessageActive.setCreateTs(tUserMessageSummary.getCreateTs());
        sUserMessageActive.setlUserMessageId(tUserMessageSummary.gethMessageId());
        sUserMessageActive.setsUserMessageActiveInd(tUserMessageSummary.getsUserMessageActiveInd());
        sUserMessageActive.setUpdateTs(tUserMessageSummary.getUpdateTs());

        return sUserMessageActive;
    }
}
