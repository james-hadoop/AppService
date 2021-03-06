package com.app_service.common;

public class GlobalConstant {
    public static final String DEFAULT_SESSION_CODE = "No Verification";
    
    public static final String NULL_STRING = "?";

    public static final String SESSION_CODE_PREFIX = "SN";

    public static final String HYPHEN = "-";

    // millisecond
    // public static final int OVERTIME_THRESHOLD=600000;
    public static final int OVERTIME_THRESHOLD = 6000000;

    private static String EVENT_VERSION = "";

    public static String getEVENT_VERSION() {
        return EVENT_VERSION;
    }

    public static void setEVENT_VERSION(String eVENT_VERSION) {
        EVENT_VERSION = eVENT_VERSION;
    }
}