package com.jonas.common;

import java.util.regex.Pattern;

/**
 * @author shenjy
 * @date 2020/11/2
 * @description
 */
public class NumberUtils {
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("-1"));
    }
}
