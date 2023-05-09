package com.john.train.batch.config;

import com.john.train.batch.job.TestJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JohnConstantine
 * @date 2023/5/10 02:46
 */
@Configuration
public class QuartzConfig {
    /**
     * 声明一个任务
     *
     * @return
     */
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(TestJob.class)
                .withIdentity("TestJob", "test")
                .storeDurably()
                .build();
    }

    /**
     * 声明一个触发器，什么时候触发这个任务
     *
     * @return
     */
    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("trigger", "trigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
                .build();
    }
}
