package com.jonas.date;

import com.jonas.common.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
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
    public void testCheckRange() {
        List<String> dates1 = Arrays.asList("2017-07-21 10:00:00-20:00:00");
        Assert.assertFalse(DateUtils.checkRange(dates1));

        List<String> dates2 = Arrays.asList("2019-12-19 10:00:00-20:00:00");
        Assert.assertTrue(DateUtils.checkRange(dates2));
    }

    @Test
    public void testGetCurrentDateTime() {
        long timestamp = DateUtils.getStampFromDate(DateUtils.getCurrentDate());
        Assert.assertEquals(timestamp, DateUtils.getTodayMorning());
    }
}
