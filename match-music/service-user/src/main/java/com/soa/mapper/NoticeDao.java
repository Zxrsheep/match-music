package com.soa.mapper;

import com.soa.entity.Notice;
import com.soa.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeDao {

    public int create(Notice notice);
    public int delete(Map<String,Object> paramMap);
    public int update(Map<String,Object> paramMap);
    public List<Notice> query(Map<String,Object> paramMap);

}
