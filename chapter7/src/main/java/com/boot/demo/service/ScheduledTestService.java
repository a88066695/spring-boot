package com.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledTestService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTestService.class);

    @Scheduled(cron = "0/1 * * * * *")
    @Async
    public void schedule1() throws InterruptedException {
        logger.info("定时任务 : {},执行时间 : {}","schedule1", LocalDateTime.now());
        Thread.sleep(3000l);
    }

    @Scheduled(cron = "0/1 * * * * *")
    public void schedule2() throws InterruptedException {
        logger.info("定时任务 : {},执行时间 : {}","schedule2", LocalDateTime.now());
        Thread.sleep(3000l);
    }
}
