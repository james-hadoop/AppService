package com.app_service.entity.hs_event.enums;

public enum REventCategoryEnum {
    Undefined("未定义", 0), Activity("盒声活动", 1), Education("音乐教学", 2), Share("艺人分享", 3), Album("音乐专辑", 4);

    private String value;
    private int code;

    private REventCategoryEnum(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public static String getValue(int code) {
        for (REventCategoryEnum c : REventCategoryEnum.values()) {
            if (c.getCode() == code) {
                return c.value;
            }
        }
        return null;
    }

    public static int getCode(String value) {
        for (REventCategoryEnum c : REventCategoryEnum.values()) {
            if (c.getValue().equals(value)) {
                return c.code;
            }
        }
        return -1;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}