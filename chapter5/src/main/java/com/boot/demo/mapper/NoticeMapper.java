package com.boot.demo.mapper;

import com.boot.demo.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    //获取列表
    List<Notice> getList();

    //新增
    void insertNotice(Notice notice);

    //更新
    void updateNotice(Notice notice);

    //删除
    void removeNotice(String id);
}
