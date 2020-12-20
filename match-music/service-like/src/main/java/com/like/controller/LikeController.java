package com.like.controller;


import com.like.entity.Like;
import com.like.framework.exception.MyException;
import com.like.service.LikeService;
import com.like.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "点赞操作接口，注意仍然需要token")
public class LikeController {

    @Autowired
    LikeService likeService;

    @ApiOperation(value = "创建点赞表",notes = "必填：用户id(user_id),音乐id(music_id)")
    @ApiImplicitParam(name = "like", value = "Like实体",required = true,dataType = "Like")
    @PostMapping("/Like")
    public Result create(@RequestBody Like like){
        if (likeService.create(like) == 1){
            return Result.ok();
        }
        else {
            throw new MyException("我也不知道为什么会有问题...注意检查两个id主键");
        }
    }

    @ApiOperation(value = "删除点赞表",notes = "给出Like信息，可实现批量删除")
    @ApiImplicitParam(name = "like", value = "Like实体",required = true,dataType = "Like")
    @DeleteMapping("/Like")
    public Result delete(@RequestBody Like like){
        return Result.ok(likeService.delete(like));
    }


    @ApiOperation(value = "更新点赞表",notes = "对应点赞状态改变")
    @ApiImplicitParam(name = "like", value = "Like实体",required = true,dataType = "Like")
    @PutMapping("/Like")
    public Result update(@RequestBody Like like){
        return Result.ok(likeService.update(like));
    }


    @ApiOperation(value = "获取点赞数",notes = "count查询，返回点赞数")
    @ApiImplicitParam(name = "music_id", value = "音乐id",dataType = "int")
    @GetMapping("/Like")
    public Result count(@RequestParam int music_id){
       int num = likeService.count(music_id);
        return Result.ok(num);
    }

    @ApiOperation(value = "查询点赞状态",notes = "必填：用户id(user_id),音乐id(music_id)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id",dataType = "int"),
            @ApiImplicitParam(name = "music_id", value = "音乐id",dataType = "int")
    })
    @GetMapping("/LikeStatus")
    public Result status(@RequestParam int user_id,@RequestParam int music_id){
        Like like = new Like();
        like.setMusic_id(music_id);
        like.setUser_id(user_id);
        List<Like> likes = likeService.query(like);
        return Result.ok(likes);
    }

}
