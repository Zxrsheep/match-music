package com.consumer.Controller;


import com.consumer.entity.User;
import com.consumer.service.UserService;
import com.consumer.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录",notes = "用户登录接口，成功后返回token")
    @ApiImplicitParam(name = "user", value = "对用户密码的user(只用于登录查询)，填写user_name，password" +
            "{\"user_name\":\"RealAdmin\",\"password\":\"123456\"}"
            ,required = true,dataType = "User")
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println(user);
        return userService.login(user);
    }

}
