package com.jonas.cron;

import org.junit.Test;

import java.util.Date;

/**
 * CronTest
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-07-19
 */
public class CronTest {
    @Test
    public void testLastTime() {
        String cron = "0 0 12 L 2 ?";
        System.out.println(CronExpressionUtil.getLastTimeStr(cron));
        System.out.println(CronExpressionUtil.getLastTimeStr(cron, new Date(1582078562000L)));
    }
}
