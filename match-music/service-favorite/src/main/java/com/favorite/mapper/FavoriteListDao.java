package com.favorite.mapper;

import com.favorite.entity.FavoriteList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FavoriteListDao {

    public int create(FavoriteList favoriteList);
    public int delete(Map<String,Object> paramMap);
    public int update(Map<String,Object> paramMap);
    public List<FavoriteList> query(Map<String,Object> paramMap);
    public FavoriteList detail(Map<String,Object> paramMap);
    public int count(Map<String,Object> paramMa);
}