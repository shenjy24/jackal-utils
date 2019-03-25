package com.jonas.security;

import java.util.regex.Pattern;

/**
 * 通过正则表达式进行校验
 *
 * @author shenjy 2019/02/14
 */
public class ValidateUtils {

    /**
     * 正则表达式：验证自定义账户
     * 5-20 数字、字母, 且必须包含字母
     */
    public static final String REGEX_ACCOUNT = "^(?![0-9]+$)[0-9A-Za-z]{5,20}$";

    /**
     * 正则表达式：验证密码
     * 6-18 不包含中文
     */
    public static final String REGEX_PWD = "^((?![\\u4e00-\\u9fa5]).){6,18}$";

    /**
     * 校验自定义账户
     *
     * @param account
     * @return
     */
    public static boolean isAccount(String account) {
        return Pattern.matches(REGEX_ACCOUNT, account);
    }

    /**
     * 校验密码
     *
     * @param pwd
     * @return
     */
    public static boolean isPassword(String pwd) {
        return Pattern.matches(REGEX_PWD, pwd);
    }

    public static void main(String[] args) {
        String pwd = "人人车窗好不好";
        System.out.println(isPassword(pwd));
    }
}
