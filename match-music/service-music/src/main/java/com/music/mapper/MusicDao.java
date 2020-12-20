package com.music.mapper;

import com.music.entity.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MusicDao {

    public int create(Music music);
    public int delete(Map<String,Object> paramMap);
    public int update(Map<String,Object> paramMap);
    public List<Music> query(Map<String,Object> paramMap);
    public Music detail(Map<String,Object> paramMap);
    public int count(Map<String,Object> paramMap);
    public int maxId();
}