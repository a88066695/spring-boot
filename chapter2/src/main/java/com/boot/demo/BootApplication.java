package com.boot.demo;

import com.boot.demo.config.properties.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootApplication {

//    @Value("${my.name}")
//    private String name;
//
//    @Value("${my.message}")
//    private String message;

    @Autowired
    private MyProperties myProperties;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class,args);
    }

    @GetMapping("/")
    public String hello(){
        return String.format("Hello %s,this is your message : %s",myProperties.getName(),myProperties.getMessage());
    }
}
