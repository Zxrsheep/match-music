package com.like.mapper;

import com.like.entity.Like;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LikeDao {

    public int create(Like like);
    public int delete(Map<String,Object> paramMap);
    public int update(Map<String,Object> paramMap);
    public List<Like> query(Map<String,Object> paramMap);
    public int count(Map<String,Object> paramMap);

}