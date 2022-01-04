package com.jonas.cron.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PrintWordsJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("PrintWordsJob2 start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
}
