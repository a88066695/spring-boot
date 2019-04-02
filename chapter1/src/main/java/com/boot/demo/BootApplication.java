package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *	我的第一个Spring Boot应用
 *	Author : Ivan
 **/
@SpringBootApplication
@RestController
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class,args);
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }
}
