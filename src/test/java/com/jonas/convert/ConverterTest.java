package com.jonas.convert;

import com.jonas.common.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author shenjiayun
 * @since 2020-01-06
 */
public class ConverterTest {
    @Test
    public void testDate() {
        String str = "2017-06-24 00:00:00";
        Long stamp = DateUtils.getStampFromTime(str);
        Date date = DateConverter.getDate(str);
        Assert.assertTrue(date.equals(new Date(stamp)));

        String dateStr = DateConverter.getStr(date);
        Assert.assertTrue(str.equals(dateStr));
    }

}
