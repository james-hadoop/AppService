package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.leyao.app_service.entity.ls_user_message.LUserMessage;
import com.leyao.app_service.entity.ls_user_message.SUserMessageActive;
import com.leyao.app_service.entity.ls_user_message.TUserMessageSummary;

public class LsUserMessageUtil {
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

    public static List<LUserMessage> makeLsUserMessageList(Long hMessageId, List<Long> rowUserIds) {
        if (null == hMessageId || null == rowUserIds || 0 == rowUserIds.size()) {
            return null;
        }

        Date createTs = new Date();
        Date updateTs = new Date();

        List<LUserMessage> lUserMessageList = new ArrayList<LUserMessage>();
        for (long userId : rowUserIds) {
            LUserMessage lUserMessage = new LUserMessage();

            lUserMessage.setCreateTs(createTs);
            lUserMessage.setUpdateTs(updateTs);
            lUserMessage.sethMessageId(hMessageId);
            lUserMessage.sethUserId(userId);
            lUserMessageList.add(lUserMessage);
        }

        return lUserMessageList;
    }

    public static SUserMessageActive userMessage2UserMessageActive(LUserMessage lUserMessage) {
        SUserMessageActive sUserMessageActive = new SUserMessageActive();
        sUserMessageActive.setCreateTs(lUserMessage.getCreateTs());
        sUserMessageActive.setlUserMessageId(lUserMessage.getlUserMessageId());
        sUserMessageActive.setUpdateTs(lUserMessage.getUpdateTs());

        return sUserMessageActive;
    }
}
