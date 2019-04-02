package com.boot.demo.service;

import com.boot.demo.entity.Notice;
import com.boot.demo.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<Notice> getList(){
        return noticeMapper.getList();
    }

    @Transactional
    public void save(Notice notice){
        String noticeId = notice.getId();
        if(null != noticeId && "" != noticeId){
            noticeMapper.updateNotice(notice);
        } else {
            notice.setId(UUID.randomUUID().toString());
            noticeMapper.insertNotice(notice);
        }
    }

    @Transactional
    public void remove(String id){
        noticeMapper.removeNotice(id);
    }
}
