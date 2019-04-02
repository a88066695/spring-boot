package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *	测试定时任务
 *	Author : Ivan
 **/
@SpringBootApplication
@EnableScheduling //必需，否则无法加载定时任务
@EnableAsync    //不加则无法使用@Async注解
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class,args);
    }
}
