package com.jonas.cron.quartz;

public class QuartzMain {

    public static void main(String[] args) {
        QuartzScheduler.schedule(PrintWordsJob.class, "0/2 * * * * ?");
    }
}
