package com.soa.service;

import com.soa.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceTest {
    @Autowired
    UserService userService;
    String userName = "Stest";
    String password = "";
    String loginUserName = "RealAdmin";
    String loginPassword = "123456";


    @BeforeEach
    void setUp() {
        System.out.println("setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown...");
    }

    @Test
    void create() {
        System.out.println("create测试，因为是insert操作，和delete一同测试");
        User user = new User();
        user.setUser_name(userName);
        user.setPassword(password);
        int flag = userService.create(user);
        assertEquals(1,flag);
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void delete() {
        System.out.println("delete测试，因为是delete操作，和create一同测试");
        //对test中创建对user通过login获取id并进行删除测试
        User user = userService.login(userName,password);
        int flag = userService.delete(user.getId());
        assertEquals(1,flag);
        System.out.println("assertEqual通过，测试成功");

    }

    @Test
    void update() {
        int id = 4;
        System.out.println("update服务测试，使用id:"+id+"，更新tel");
        User user = new User();
        user.setId(id);
        user.setTel("19921301111");
        int flag = userService.update(user);
        assertEquals(1,flag);
        System.out.println("assertEqual通过，测试成功");
    }

    @Test
    void detail() {
        int id = 4;
        System.out.println("detail服务测试，测试使用id："+id);
        User user = userService.detail(id);
        if (user==null){
            System.out.println("null，id输入错误");
        }
        else{
            assertEquals("RealAdmin",user.getUser_name());
            System.out.println("assertEqual通过，测试成功,id:"+id
                    +"对应查询用户名："+user.getUser_name());
        }
    }

    @Test
    void login() {
        System.out.println("login 服务测试,使用的user_name:RealAdmin,password:123456");
        User user = userService.login(loginUserName,loginPassword);
        assertEquals("RealAdmin",user.getUser_name());
        System.out.println("assertEqual通过，测试成功，得到用户名："+user.getUser_name()
        +"得到用户姓名："+user.getName());
    }
}