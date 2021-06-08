package com.favorite.service;

import com.favorite.entity.FavoriteList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class FavoriteListServiceTest {
    @Autowired
    FavoriteListService favoriteListService;
    int id;
    int user_id;


    @BeforeEach
    void setUp() {
        System.out.println("setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown...");
        this.id = 1;
        this.user_id = 4;
    }

    @Test
    void update() {
        System.out.println("update服务测试");
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setId(id);
        favoriteList.setName("favorite");
        int flag = favoriteListService.update(favoriteList);
        assertEquals(1,flag);
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void query() {
        System.out.println("query服务测试");
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setUser_id(user_id);
        List<FavoriteList> list = favoriteListService.query(favoriteList);
        assertEquals(1,list.get(0).getId());
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void detail() {
        System.out.println("detail服务测试");
        FavoriteList favoriteList = favoriteListService.detail(id);
        assertEquals(4,favoriteList.getUser_id());
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void count() {
        System.out.println("count服务测试");
        int count = favoriteListService.count(user_id);
        assertEquals(3,count);
        System.out.println("assertEqual通过，测试成功");
    }
}