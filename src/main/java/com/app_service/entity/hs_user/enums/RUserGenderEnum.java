package com.app_service.entity.hs_user.enums;

public enum RUserGenderEnum {
    UnKnown("未知", 0), Male("男", 1), FeMale("女", 2);

    private String value;
    private int code;

    private RUserGenderEnum(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public static String getValue(int code) {
        for (RUserGenderEnum c : RUserGenderEnum.values()) {
            if (c.getCode() == code) {
                return c.value;
            }
        }
        return null;
    }

    public static int getCode(String value) {
        for (RUserGenderEnum c : RUserGenderEnum.values()) {
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