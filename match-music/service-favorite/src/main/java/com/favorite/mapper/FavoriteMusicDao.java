package com.favorite.mapper;

import com.favorite.entity.FavoriteMusic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FavoriteMusicDao {

    public int create(FavoriteMusic favoriteMusic);
    public int delete(Map<String,Object> paramMap);
    public int update(Map<String,Object> paramMap);
    public List<FavoriteMusic> query(Map<String,Object> paramMap);
    public FavoriteMusic detail(Map<String,Object> paramMap);
    public int count(Map<String,Object> paramMap);
}