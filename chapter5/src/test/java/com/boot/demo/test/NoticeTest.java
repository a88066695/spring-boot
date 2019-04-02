package com.boot.demo.test;

import com.boot.demo.entity.Notice;
import com.boot.demo.service.NoticeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.web-application-type=reactive")
public class NoticeTest {

    private static final Logger logger = LoggerFactory.getLogger(NoticeTest.class);

    @Autowired
    private NoticeService noticeService;

    @Test
    public void getNoticeListTest(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Notice> notices = noticeService.getList();
        for(Notice notice : notices){
            try {
                logger.info(objectMapper.writeValueAsString(notice));
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage(),e);
            }
        }
    }

    @Test
    public void addNotice(){
        //新增
        Notice notice = new Notice();
        notice.setContext("呵呵哒");
        notice.setSort(0);
        noticeService.save(notice);
    }

    @Test
    public void updateNotice(){
        Notice notice = new Notice();
        notice.setId("noticeId");   //noticeId替换为需要操作的记录id
        notice.setIsUse((byte)1);
        noticeService.save(notice);
    }

    @Test
    public void removeNotice(){
        noticeService.remove("noticeId"); //noticeId替换为需要操作的记录id
    }
}
