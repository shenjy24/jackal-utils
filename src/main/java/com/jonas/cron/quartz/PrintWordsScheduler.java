package com.jonas.cron.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.TriggerBuilder.newTrigger;

public class PrintWordsScheduler {

    public static void main(String[] args) {
        try {
            // 1、创建调度器Scheduler
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
            JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class).withIdentity("PrintWordsJob", "PrintWordsJob").build();
            // 3、构建Trigger实例
            String cron = "0/2 * * * * ?";
            Trigger trigger = newTrigger().withIdentity("PrintWordsTrigger", "PrintWordsTrigger")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
            // 4、执行
            scheduler.scheduleJob(jobDetail, trigger);
            System.out.println("--------scheduler start ! ------------");
            scheduler.start();

            //睡眠
            TimeUnit.MINUTES.sleep(1);
            scheduler.shutdown();
            System.out.println("--------scheduler shutdown ! ------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
