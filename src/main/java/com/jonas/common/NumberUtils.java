package com.jonas.common;

import java.util.regex.Pattern;

/**
 * @author shenjy
 * @date 2020/11/2
 * @description
 */
public class NumberUtils {

    /**
     * 判断是否是数字字符串
     *
     * @param str 字符串
     * @return 是否是数字字符串
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 整数x和y是否异号
     *
     * @param x 整数X
     * @param y 整数Y
     * @return 是否异号
     */
    public static boolean isOppositeSign(int x, int y) {
        return (x ^ y) < 0;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("-1"));
        System.out.println(isOppositeSign(0, -1));
    }
}
