package com.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("test")
    public Map test(){
        Map<String,String> result = new HashMap<>();
        try {
            //业务代码
            result.put("code","200");
            result.put("msg","请求成功");
        } catch (Exception e){
            logger.error("请求失败",e.getLocalizedMessage(),e);
            result.put("code","500");
            result.put("msg","请求失败");
        }

        return result;
    }

    @RequestMapping("test2")
    public Map test2(){
        Map<String,String> result = new HashMap<>();
        int i = 10 / 0;
        result.put("code","200");
        result.put("msg","请求成功");
        return result;
    }
}
