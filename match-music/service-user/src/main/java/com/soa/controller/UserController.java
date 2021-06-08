package com.soa.controller;

import com.soa.entity.User;
import com.soa.framework.exception.MyException;
import com.soa.service.UserService;
import com.soa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户相关信息操作接口")
public class UserController {


    @Autowired
    private UserService userService;


    @ApiOperation(value = "创建用户",notes = "create,对应用户的注册接口。注意！由于拦截器需要这里添加了create路径")
    @ApiImplicitParam(name = "user", value = "用户实体",required = true,dataType = "User")
    @PostMapping("/user/create")
    public Result create(@RequestBody User user){
        if (userService.create(user) == 1){
            return Result.ok();
        }
        else {
            throw new MyException("用户名重复");
        }
    }

    @ApiOperation(value = "删除用户",notes = "delete，对应用户的注销账号接口")
    @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "int")
    @DeleteMapping("/user")
    public Result delete(@RequestParam("id") int id){
        return Result.ok(userService.delete(id));
    }


    @ApiOperation(value = "更新用户信息",notes = "update，对应用户更新完善信息接口，不需要使用id，在user中自动找到id并将其他部分比较更新")
    @ApiImplicitParam(name = "user", value = "用户实体",required = true,dataType = "User")
    @PutMapping("/user")
    public Result update(@RequestBody User user){
        return Result.ok(userService.update(user));
    }


    @ApiOperation(value = "查询用户信息",notes = "detail，查询对应id的单个用户的信息")
    @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "int")
    @GetMapping("/user")
    public Result detail(@RequestParam("id") int id){
        User user = userService.detail(id);
        if (user==null){
            return Result.fail("查询失败");
        }
        return Result.ok(user);
    }




    public String error(){
        return "Sorry,Service failure!";
    }

}
