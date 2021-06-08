package com.soa.controller;


import com.soa.entity.User;
import com.soa.framework.jwt.JWTUtil;
import com.soa.service.UserService;
import com.soa.utils.Maps;
import com.soa.utils.Result;
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
    @ApiImplicitParam(name = "user0", value = "对用户密码的user(只用于登录查询)，填写user_name，password {\"user_name\":\"RealAdmin\",\"password\":\"123456\"}"
            ,required = true,dataType = "User")
    @PostMapping("/login")
    public Result login(@RequestBody User user0){
        String userName = user0.getUser_name();
        String password = user0.getPassword();

        User user = userService.login(userName,password);
        if (user != null){
            String token = JWTUtil.sign(user);
            Map<String,Object> loginMap = Maps.build().put("token",token).put("user",user).getMap();
            return  Result.ok(loginMap);
        }
        else {
            return Result.fail("用户名或密码错误");
        }
    }

}
