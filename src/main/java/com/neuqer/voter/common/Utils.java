package com.neuqer.voter.common;

import java.util.Random;
import java.util.UUID;

/**
 * Created by yinzhe on 17/5/9.
 */
public class Utils {

    private static Random ra;

    public static long createTimeStamp() {
        return System.currentTimeMillis();
    }

    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String createVerifyCode() {
        return Utils.createVerifyCode(4);
    }

    public static String createVerifyCode(int size) {
        if (ra == null)
            ra = new Random();
        StringBuilder vc = new StringBuilder();
        for (int i = 0; i < size; i++) {
            vc.append(ra.nextInt(10));
        }
        return vc.toString();

    }
}
