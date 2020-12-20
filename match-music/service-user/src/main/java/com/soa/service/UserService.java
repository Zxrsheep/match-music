package com.soa.service;

import com.soa.entity.User;
import com.soa.mapper.UserDao;
import com.soa.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int create(User user){
        return userDao.create(user);
    }

    public int delete(int id){
        return userDao.delete(Maps.build("id",id).getMap());
    }

    public int update(User user){
        return userDao.update(Maps.build(user.getId()).beanToMapForUpdate(user));
    }

    public List<User> query(User user){
        return userDao.query(Maps.build().beanToMap(user));
    }

    public User detail(int id){

        return userDao.detail(Maps.build(id).getMap());
    }

    public int count(User user){
        return userDao.count(Maps.build().beanToMap(user));
    }

    public User login(String user_name,String password) {
        return userDao.detail(Maps.build().put("user_name", user_name)
                .put("password", password)
                .getMap());
    }
}
