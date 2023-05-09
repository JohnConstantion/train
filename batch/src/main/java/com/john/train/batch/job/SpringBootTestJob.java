//package com.john.train.batch.job;
//
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * 适合单体应用，不适合集群
// * 没法实时更改定时任务状态和策略
// *
// * @author JohnConstantine
// * @date 2023/5/10 02:20
// */
//@Component
//@EnableScheduling
//public class SpringBootTestJob {
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void testJob() {
//        // 增加分布式锁，解决集群问题
//        System.out.println("SpringBootTestJob TEST");
//    }
//}
