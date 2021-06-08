package com.favorite.service;


import com.favorite.entity.FavoriteList;
import com.favorite.mapper.FavoriteListDao;
import com.favorite.mapper.FavoriteMusicDao;
import com.favorite.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteListService {

    @Autowired
    FavoriteListDao favoriteListDao;

    @Autowired
    FavoriteMusicDao favoriteMusicDao;

    public int create(FavoriteList favoriteList){
        return favoriteListDao.create(favoriteList);
    }

    public int delete(int id){
        return favoriteListDao.delete(Maps.build("id",id).getMap());
    }

    public int update(FavoriteList favoriteList){
        return favoriteListDao.update(Maps.build(favoriteList.getId()).beanToMapForUpdate(favoriteList));
    }

    public List<FavoriteList> query(FavoriteList favoriteList){
        return favoriteListDao.query(Maps.build().beanToMap(favoriteList));
    }

    public FavoriteList detail(int id){
        return favoriteListDao.detail(Maps.build(id).getMap());
    }

    public int count(int id){
        return favoriteListDao.count(Maps.build(id).getMap());
    }

}
