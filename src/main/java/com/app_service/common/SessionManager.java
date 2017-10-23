package com.app_service.common;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.app_service.entity.hs_user.TUserSummary;
import com.app_service.util.CommonUtil;

public class SessionManager {
    private static int USER_COUNT = 0;
    private static Map<String, TUserSummary> USER_SESSION_MAP = new ConcurrentHashMap<String, TUserSummary>();

    public static String newSession(TUserSummary user) {
        Date date = new Date();

        String sessionCode = CommonUtil.generateUuid(GlobalConstant.SESSION_CODE_PREFIX, date);

        ++USER_COUNT;
        if (USER_COUNT >= Integer.MAX_VALUE) {
            USER_COUNT = 0;
        }

        USER_SESSION_MAP.put(sessionCode, user);

        return sessionCode;
    }

    public static TUserSummary getUserBySessionCode(String sessionCode) {
        return USER_SESSION_MAP.get(sessionCode);
    }

    public static void removeSession(String sessionCode) {
        if (USER_SESSION_MAP.containsKey(sessionCode)) {
            USER_SESSION_MAP.remove(sessionCode);
        }
    }
}