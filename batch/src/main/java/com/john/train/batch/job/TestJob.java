package com.john.train.batch.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author JohnConstantine
 * @date 2023/5/10 02:46
 */
public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("TestJob TEST");
    }
}
