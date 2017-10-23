package com.app_service.entity.hs_event.enums;

public enum REventActiveEnum {
    Active("Active", 0), Unactive("Unactive", 1);

    private String value;
    private int code;

    private REventActiveEnum(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public static String getValue(int code) {
        for (REventActiveEnum c : REventActiveEnum.values()) {
            if (c.getCode() == code) {
                return c.value;
            }
        }
        return null;
    }

    public static int getCode(String value) {
        for (REventActiveEnum c : REventActiveEnum.values()) {
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