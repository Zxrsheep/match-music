package com.music.service;

import com.music.entity.Music;
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
class MusicServiceTest {
    @Autowired
    MusicService musicService;
    int searchId = 5;

    @BeforeEach
    void setUp() {
        System.out.println("setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown...");
    }

    @Test
    void update() {
        System.out.println("update测试，判断Dao层返回值是否正确");
        Music music = new Music();
        music.setId(searchId);
        music.setName("都走了");
        int flag = musicService.update(music);
        assertEquals(1,flag);
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void query() {
        System.out.println("query测试，查看是否返回正确信息");
        Music music = new Music();
        music.setId(searchId);
        List<Music> list = musicService.query(music);
        assertEquals("都走了",list.get(0).getName());
        System.out.println(list.get(0).getId());
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void detail() {
        System.out.println("detail测试，查看是否返回正确信息");
        Music music = musicService.detail(searchId);
        assertEquals("都走了",music.getName());
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void count() {
        System.out.println("count测试，返回满足要求音乐数量");
        Music music = new Music();
        music.setId(searchId);
        int count = musicService.count(music);
        assertEquals(1,count);
        System.out.println("预期count：1");
        System.out.println("assertEqual通过，测试成功");


    }

    @Test
    void newMusic() {
        System.out.println("newMusic测试，直接返回最新音乐");
        Music music = musicService.newMusic();
        assertEquals(24,music.getId());
        System.out.println("预期id：24");
        System.out.println("assertEqual通过，测试成功");
    }
}