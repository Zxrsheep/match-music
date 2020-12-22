package com.soa.service;

import com.github.pagehelper.PageHelper;
import com.soa.entity.Notice;
import com.soa.entity.User;
import com.soa.mapper.NoticeDao;
import com.soa.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeDao noticeDao;

    public int create(Notice notice){
        return noticeDao.create(notice);
    }

    public int delete(int id){
        return noticeDao.delete(Maps.build("id",id).getMap());
    }

    public int update(Notice notice){
        return noticeDao.update(Maps.build(notice.getId()).beanToMapForUpdate(notice));
    }

    public List<Notice> query(Notice notice){
        return noticeDao.query(Maps.build().beanToMap(notice));
    }

    public List<Notice> page(Notice notice){
        PageHelper.startPage(notice.getPage(),notice.getLimit());
        return noticeDao.query(Maps.build().beanToMap(notice));
    }

}
