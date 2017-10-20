package com.leyao.app_service.entity.ls_user_message;

import java.util.List;

public class TUserMessageRequest {
    private Long hMessageId;
    private List<Long> hUserIds;

    public TUserMessageRequest() {

    }

    public Long gethMessageId() {
        return hMessageId;
    }

    public void sethMessageId(Long hMessageId) {
        this.hMessageId = hMessageId;
    }

    public List<Long> gethUserIds() {
        return hUserIds;
    }

    public void sethUserIds(List<Long> hUserIds) {
        this.hUserIds = hUserIds;
    }
}
