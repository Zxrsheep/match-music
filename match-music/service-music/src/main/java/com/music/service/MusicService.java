package com.music.service;

import com.music.entity.Music;
import com.music.mapper.MusicDao;
import com.music.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicDao musicDao;

    public int create(Music music){
        return musicDao.create(music);
    }

    public int delete(int id){
        return musicDao.delete(Maps.build("id",id).getMap());
    }

    public int update(Music music){
        return musicDao.update(Maps.build(music.getId()).beanToMapForUpdate(music));
    }

    public List<Music> query(Music music){
        return musicDao.query(Maps.build().beanToMap(music));
    }

    public Music detail(int id){
        return musicDao.detail(Maps.build(id).getMap());
    }

    public int count(Music music){
        return musicDao.count(Maps.build().beanToMap(music));
    }

    public Music newMusic(){
        int id = musicDao.maxId();
        return musicDao.detail(Maps.build(id).getMap());
    }

}
