package com.jonas;

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
     * 校验自定义账户
     *
     * @param account
     * @return
     */
    public static boolean isAccount(String account) {
        return Pattern.matches(REGEX_ACCOUNT, account);
    }

    public static void main(String[] args) {
        String account1 = "12345";
        System.out.println(isAccount(account1));

        String account2 = "123a45";
        System.out.println(isAccount(account2));

        String account3 = "a12345";
        System.out.println(isAccount(account3));

        String account4 = "12345a";
        System.out.println(isAccount(account4));

        String account5 = "ascdkd";
        System.out.println(isAccount(account5));
    }
}
