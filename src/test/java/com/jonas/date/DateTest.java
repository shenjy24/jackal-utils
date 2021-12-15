package com.jonas.date;

import com.jonas.common.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author shenjiayun
 * @since 2019-12-19
 */
public class DateTest {

    @Test
    public void testFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日hh点mm分"));
        System.out.println(str);
    }

    @Test
    public void testCheckRange() {
        List<String> dates1 = Arrays.asList("2017-07-21 10:00:00-20:00:00");
        Assert.assertFalse(DateUtils.checkRange(dates1));

        List<String> dates2 = Arrays.asList("2019-12-19 10:00:00-20:00:00");
        Assert.assertTrue(DateUtils.checkRange(dates2));
    }

    @Test
    public void getStamp() {
        String datetime = DateUtils.getCurrentDate() + " 05:00:00";
        System.out.println(DateUtils.getStampFromTime(datetime));
    }

    @Test
    public void test() {
        String datetime = "2020-12-12 0:20";
        System.out.println(new SimpleDateFormat("y-M-d H:m").format(datetime));
    }

    @Test
    public void testDayOfWeek() {
        System.out.println(DateUtils.getDayOfWeekDateTime(DayOfWeek.MONDAY));
        System.out.println(DateUtils.getDayOfWeek(DayOfWeek.MONDAY));
    }

    @Test
    public void testLastDayOfWeek() {
        System.out.println(DateUtils.getDayOfWeekDateTime(DayOfWeek.MONDAY.minus(7)));

    }

    @Test
    public void testAdjuster() {
        System.out.println(DateUtils.getLastDayOfMonth());
    }

    @Test
    public void testToday() {
        String date = DateUtils.getCurrentDate();
        System.out.println(DateUtils.getStampFromDate(date));
    }

    @Test
    public void testBetween() {
        LocalDate createDate = LocalDate.of(2021, 12, 12);
        LocalDate currentDate = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(createDate, currentDate));
    }
}
