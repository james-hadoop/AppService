package com.leyao.app_service.util;

import com.leyao.app_service.entity.hs_message.HsMessage;
import com.leyao.app_service.entity.hs_message.SMessageActive;
import com.leyao.app_service.entity.hs_message.SMessageCategory;
import com.leyao.app_service.entity.hs_message.SMessageContent;
import com.leyao.app_service.entity.hs_message.TMessageSummary;

public class HsMessageUtil {
    public static HsMessage messageSummary2Message(TMessageSummary tMessageSummary) {
        HsMessage hsMessage = new HsMessage();
        hsMessage.setCreateTs(tMessageSummary.getCreateTs());
        hsMessage.sethMessageId(tMessageSummary.gethMessageId());
        hsMessage.setUpdateTs(tMessageSummary.getUpdateTs());

        return hsMessage;
    }

    public static SMessageActive messageSummary2MessageActive(TMessageSummary tMessageSummary) {
        SMessageActive sMessageActive = new SMessageActive();
        sMessageActive.setCreateTs(tMessageSummary.getCreateTs());
        sMessageActive.sethMessageId(tMessageSummary.gethMessageId());
        sMessageActive.setsMessageActiveInd(tMessageSummary.getsMessageActiveInd());
        sMessageActive.setUpdateTs(tMessageSummary.getUpdateTs());

        return sMessageActive;
    }

    public static SMessageCategory messageSummary2MessageCategory(TMessageSummary tMessageSummary) {
        SMessageCategory sMessageCategory = new SMessageCategory();
        sMessageCategory.setCreateTs(tMessageSummary.getCreateTs());
        sMessageCategory.sethMessageId(tMessageSummary.gethMessageId());
        sMessageCategory.setsMessageCategoryCd(tMessageSummary.getsMessageCategoryCd());
        sMessageCategory.setUpdateTs(tMessageSummary.getUpdateTs());

        return sMessageCategory;
    }

    public static SMessageContent messageSummary2MessageContent(TMessageSummary tMessageSummary) {
        SMessageContent sMessageContent = new SMessageContent();
        sMessageContent.setCreateTs(tMessageSummary.getCreateTs());
        sMessageContent.sethMessageId(tMessageSummary.gethMessageId());
        sMessageContent.setsMessageContentStr(tMessageSummary.getsMessageContentStr());
        sMessageContent.setUpdateTs(tMessageSummary.getUpdateTs());

        return sMessageContent;
    }
}