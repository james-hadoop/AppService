package com.leyao.app_service.entity.ls_user_event.enums;

public enum RUserEventCategoryEnum {
    Like("Like", 1), Read("Read", 2);

    private String value;
    private int code;

    private RUserEventCategoryEnum(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public static String getValue(int code) {
        for (RUserEventCategoryEnum c : RUserEventCategoryEnum.values()) {
            if (c.getCode() == code) {
                return c.value;
            }
        }
        return null;
    }

    public static int getCode(String value) {
        for (RUserEventCategoryEnum c : RUserEventCategoryEnum.values()) {
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