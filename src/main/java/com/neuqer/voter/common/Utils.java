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
            int a = ra.nextInt(10);
            System.out.println(a);
            if ((a == 0) && (i == 0))
            {
                i= i -1;
                continue;
            }
            else
            vc.append(a);
        }
        return vc.toString();

    }
    public static String createUserName(){
        String base = "abcdefghijklmnopqrstuvwxyz123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static String createUserPassword(){
        String base = "123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static String createRobotMobile(){
        String base = "345678";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 11; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
