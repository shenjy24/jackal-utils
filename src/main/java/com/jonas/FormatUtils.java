package com.jonas;

import java.text.DecimalFormat;

/**
 * 【 容量转换 】
 *
 * @author shenjy 2018/09/21
 */
public class FormatUtils {

    public static void main(String[] args) {
        Long ms = 1541650820000L;
        System.out.println(formatTime(ms));
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
     * 时间大小转换
     *
     * @param second
     * @return
     */
    public static String formatSecond(int second) {
        int h = second / 3600;
        int m = (second % 3600) / 60;
        int s = (second % 3600) % 60;

        StringBuilder time = new StringBuilder();
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
        } else if (10 > num){
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
}
