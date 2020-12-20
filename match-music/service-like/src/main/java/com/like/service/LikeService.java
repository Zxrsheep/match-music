package com.like.service;


import com.like.entity.Like;
import com.like.mapper.LikeDao;
import com.like.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    LikeDao likeDao;

    public int create(Like like){
        return likeDao.create(like);
    }

    public int delete(Like like){
        return likeDao.delete(Maps.build().beanToMap(like));
    }

    public int update(Like like){
        Maps F = Maps.build("user_id",like.getUser_id()).put("music_id",like.getMusic_id());
        return likeDao.update(F.beanToMapForUpdate(like));
    }

    public List<Like> query(Like like){
        return likeDao.query(Maps.build().beanToMap(like));
    }

    public int count(int music_id){
        return likeDao.count(Maps.build("music_id",music_id).getMap());
    }

}
