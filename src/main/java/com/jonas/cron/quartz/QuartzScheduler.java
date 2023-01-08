package com.jonas.cron.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzScheduler {

    private static Scheduler scheduler;

    static {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void schedule(Class<? extends Job> jobClass, String cron) {
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity("Job_" + jobClass.getName(), "JobGroup").build();
        Trigger trigger = newTrigger().withIdentity("Trigger_" + jobClass.getName(), "TriggerGroup").withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
