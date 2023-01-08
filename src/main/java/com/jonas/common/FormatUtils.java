package com.jonas.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 【 容量转换 】
 *
 * @author shenjy 2018/09/21
 */
public class FormatUtils {

    private static final BigInteger THRESHOLD = new BigInteger("1000000");
    private static List<Currency> currencies = new ArrayList<Currency>() {{
        add(new Currency("兆", new BigInteger("1000000000000")));
        add(new Currency("亿", new BigInteger("100000000")));
        add(new Currency("万", new BigInteger("10000")));
    }};

    public static void main(String[] args) {
        int ms = 0;
        System.out.println(formatDuration(ms));
        System.out.println(formatSecond(ms));
    }

    public static String formatNumber(BigInteger amount) {
        if (amount.compareTo(THRESHOLD) < 1) {
            return amount.toString();
        }

        StringBuilder res = new StringBuilder();
        for (Currency currency : currencies) {
            BigInteger num = amount.divide(currency.getRate());
            if (0 <= num.compareTo(BigInteger.ONE)) {
                res.append(num).append(currency.getName());
                amount = amount.remainder(currency.getRate());
            }
        }
        return StringUtils.isNotBlank(res.toString()) ? res.toString() : amount.toString();
    }

    /**
     * 容量大小转换
     *
     * @param size
     * @return
     */
    public static String formatSize(int size) {
        DecimalFormat df = new DecimalFormat("#.00");
        String sizeString = "";
        if (size < 1024) {
            sizeString = df.format((double) size) + "B";
        } else if (size < 1048576) {
            sizeString = df.format((double) size / 1024) + "K";
        } else if (size < 1073741824) {
            sizeString = df.format((double) size / 1048576) + "M";
        } else {
            sizeString = df.format((double) size / 1073741824) + "G";
        }
        return sizeString;
    }

    /**
     * 格式化字符串
     *
     * @param str 字符串
     * @return 格式化字符串
     */
    private static String formatName(String str) {
        StringBuilder formatName = new StringBuilder(str);
        int mid = formatName.length() / 2;
        if (5 >= formatName.length()) {
            return formatName.replace(mid, mid + 1, "*").toString();
        } else if (8 >= formatName.length()) {
            return formatName.replace(mid - 1, mid + 2, "***").toString();
        } else {
            return formatName.replace(mid - 2, mid + 3, "*****").toString();
        }
    }

    /**
     * 时间大小转换
     *
     * @param second
     * @return
     */
    public static String formatSecond(int second) {
        int d = second / (3600 * 24);
        int h = (second % (3600 * 24)) / 3600;
        int m = (second % 3600) / 60;
        int s = (second % 3600) % 60;

        StringBuilder time = new StringBuilder();
        if (0 != d) {
            time.append(d + "天");
        }
        if (0 != h) {
            time.append(h + "小时");
        }
        if (0 != m) {
            time.append(m + "分");
        }
        if (0 != s) {
            time.append(s + "秒");
        }

        return time.toString();
    }

    /**
     * 时长转化为00:00:00的格式
     *
     * @param second
     * @return
     */
    public static String formatDuration(int second) {
        int h = second / 3600;
        int m = (second % 3600) / 60;
        int s = (second % 3600) % 60;

        return String.format("%s:%s:%s", parse(h), parse(m), parse(s));
    }

    private static String parse(int num) {
        if (0 == num) {
            return "00";
        } else if (10 > num) {
            return "0" + num;
        } else {
            return String.valueOf(num);
        }
    }

    /**
     * 日期格式转换
     * 1、1小时内显示XX分钟前。
     * 2、今天之内显示XX小时前。
     * 3、非今天显示：X天前。昨天：1天前，前天：2天前
     * 4、非本月显示：1个月前
     * 5、非本年度显示：1年前
     *
     * @param millisecond
     * @return
     */
    public static String formatTime(Long millisecond) {
        Integer past = DateUtils.parseToSecond(millisecond);
        Integer now = DateUtils.currentSecond();
        Integer between = now - past;

        if (between < 0) {
            return "";
        } else if (between < DateUtils.HOUR_SECOND) {
            Integer minute = between / 60;
            return minute + "分钟前";
        } else if (between < DateUtils.DAY_SECOND) {
            Integer hour = between / DateUtils.HOUR_SECOND;
            return hour + "小时前";
        } else if (between < DateUtils.MONTH_SECOND) {
            Integer day = between / DateUtils.DAY_SECOND;
            return day + "天前";
        } else if (between < DateUtils.YEAR_SECOND) {
            Integer month = between / DateUtils.MONTH_SECOND;
            return month + "个月前";
        } else {
            Integer year = between / DateUtils.YEAR_SECOND;
            return year + "年前";
        }
    }

    /**
     * 格式化数字，有小数保留scale位，无小数显示整数
     *
     * @param num   数字
     * @param scale 保留位数
     * @return
     */
    public static String formatDouble(double num, int scale) {
        BigDecimal bg = new BigDecimal(num).setScale(scale, RoundingMode.DOWN);
        double value = bg.doubleValue();
        if (Math.round(value) - value == 0) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Currency {
        private String name;
        private BigInteger rate;
    }
}
