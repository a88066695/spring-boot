package com.boot.demo.test;

import com.boot.demo.entity.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.web-application-type=reactive")
public class RedisTest {

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Test
    public void get(){
        Notice notice = new Notice();
        notice.setId("111");
        notice.setContext("Hello");
        String key = "string:notice";
        valueOperations.set(key,notice);
        System.out.println(notice);
        notice = (Notice)valueOperations.get(key);
        System.out.println(notice);
    }
}
