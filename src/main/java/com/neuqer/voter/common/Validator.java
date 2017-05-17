package com.neuqer.voter.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yinzhe on 17/5/9.
 */
public class Validator {

    /**
     * 验证手机号合法性
     * @param mobile
     * @return
     */
    public static boolean validateMobile(String mobile) {
        String pattern = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(mobile);
        return matcher.matches();
    }
    /*

     */
    public static boolean validatorType(int type) {
        List<Integer> allTypes = new ArrayList<Integer>() {{
            add(1);
        }};
        return allTypes.contains(type);
    }
}
