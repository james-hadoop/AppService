package com.leyao.app_service.tester;

import java.util.Date;

public class TimeTester {
    public static void main(String[] args) {
        Date date = new Date();

        long t1 = date.getTime();
        long t2 = 1504947416084l;

        System.out.println(date.getTime());
        System.out.println(t1 - t2);
    }
}
