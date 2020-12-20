package com.favorite.service;


import com.favorite.entity.FavoriteMusic;
import com.favorite.mapper.FavoriteMusicDao;
import com.favorite.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteMusicService {

    @Autowired
    FavoriteMusicDao favoriteMusicDao;

    public int create(FavoriteMusic favoriteMusic){
        return favoriteMusicDao.create(favoriteMusic);
    }

    public int delete(int favorite_id,int music_id){
        Maps favoriteMusic = Maps.build("favorite_id",favorite_id);
        favoriteMusic.add(Maps.build("music_id",music_id).getMap());
        return favoriteMusicDao.delete(favoriteMusic.getMap());
    }

    public int update(FavoriteMusic favoriteMusic){
        Maps F = Maps.build("favorite_id",favoriteMusic.getFavorite_id()).put("music_id",favoriteMusic.getMusic_id());
        return favoriteMusicDao.update(F.beanToMapForUpdate(favoriteMusic));
    }

    public List<FavoriteMusic> query(FavoriteMusic favoriteMusic){
        return favoriteMusicDao.query(Maps.build().beanToMap(favoriteMusic));
    }

    public FavoriteMusic detail(int favorite_id){
        return favoriteMusicDao.detail(Maps.build(favorite_id).getMap());
    }

}
