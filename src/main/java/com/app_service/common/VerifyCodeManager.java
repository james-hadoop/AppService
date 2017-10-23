package com.app_service.common;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class VerifyCodeManager {
    /**
     * verifyCodeWithTimestamp format: 1234-1504947154
     * 
     * VERIFY_CODE_MAP entry: <"13333333333","1234-1504947154">
     */
    private static Map<String, String> VERIFY_CODE_MAP = new ConcurrentHashMap<String, String>();

    public static String generateVerifyCode(String phoneNum) {
        Random random = new Random();
        int randomNum = random.nextInt(8999) + 1000;
        String verifyCode = String.valueOf(randomNum);
        String oldVerifyCode = getVerifyCodeByPhoneNum(phoneNum);

        if (null == oldVerifyCode) {
            VERIFY_CODE_MAP.put(phoneNum, makeVerifyCode(verifyCode, new Date()));
            return verifyCode;
        } else {
            return oldVerifyCode;
        }
    }

    public static String getVerifyCodeByPhoneNum(String phoneNum) {
        String verifyCodeWitTimestamp=VERIFY_CODE_MAP.get(phoneNum);
        
        if (null == verifyCodeWitTimestamp) {
            return null;
        }

        if (isVerifyCodeOverTime(verifyCodeWitTimestamp)) {
            return null;
        } else {
            return extractVerifyCode(verifyCodeWitTimestamp);
        }
    }

    public static void removePhoneCodeByPhoneNum(String phoneNum) {
        if (VERIFY_CODE_MAP.containsKey(phoneNum)) {
            VERIFY_CODE_MAP.remove(phoneNum);
        }
    }

    private static String extractVerifyCode(String verifyCodeWithTimestamp) {
        if (null == verifyCodeWithTimestamp || !verifyCodeWithTimestamp.contains(GlobalConstant.HYPHEN)) {
            return null;
        }

        return verifyCodeWithTimestamp.substring(0, verifyCodeWithTimestamp.indexOf(GlobalConstant.HYPHEN));
    }

    private static String extractTimeStamp(String verifyCodeWithTimestamp) {
        if (null == verifyCodeWithTimestamp || !verifyCodeWithTimestamp.contains(GlobalConstant.HYPHEN)) {
            return null;
        }

        return verifyCodeWithTimestamp.substring(verifyCodeWithTimestamp.indexOf(GlobalConstant.HYPHEN) + 1,
                verifyCodeWithTimestamp.length());
    }

    private static String makeVerifyCode(String verifyCode, Date timestamp) {
        return verifyCode + GlobalConstant.HYPHEN + timestamp.getTime();
    }

    private static boolean isOverTime(long newTimestamp, long oldTimestamp) {
        return Math.abs(newTimestamp - oldTimestamp) > GlobalConstant.OVERTIME_THRESHOLD;
    }

    private static boolean isVerifyCodeOverTime(String verifyCodeWithTimestamp) {
        if (null == verifyCodeWithTimestamp || !verifyCodeWithTimestamp.contains(GlobalConstant.HYPHEN)) {
            return true;
        }

        boolean result = isOverTime(new Date().getTime(), Long.parseLong(extractTimeStamp(verifyCodeWithTimestamp)));

        return result;
    }
}