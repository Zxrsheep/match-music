package com.music.controller;

import com.music.entity.Music;
import com.music.framework.exception.MyException;
import com.music.service.MusicService;
import com.music.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "推荐音乐相关信息操作接口，注意仍然需要token")
public class MusicController {

    @Autowired
    private MusicService musicService;


    @ApiOperation(value = "新建推荐音乐",notes = "require的必须填写！")
    @ApiImplicitParam(name = "music", value = "音乐实体",required = true,dataType = "Music")
    @PostMapping("/music")
    public Result create(@RequestBody Music music){
        if (musicService.create(music) == 1){
            return Result.ok();
        }
        else {
            throw new MyException("我也不知道为什么会有问题...");
        }
    }

    @ApiOperation(value = "删除推荐音乐",notes = "根据id删除音乐，在特殊情况下可以删除推荐音乐")
    @ApiImplicitParam(name = "id", value = "音乐id",required = true,dataType = "int")
    @DeleteMapping("/music")
    public Result delete(@RequestParam("id") int id){
        return Result.ok(musicService.delete(id));
    }


    @ApiOperation(value = "更新推荐音乐",notes = "update，管理员上传音乐后可以再次更新音乐详细信息")
    @ApiImplicitParam(name = "music", value = "音乐实体",required = true,dataType = "Music")
    @PutMapping("/music")
    public Result update(@RequestBody Music music){
        return Result.ok(musicService.update(music));
    }


    @ApiOperation(value = "查询信息",notes = "query查询，查询返回满足要求的所有list")
    @ApiImplicitParam(name = "music", value = "音乐实体",dataType = "Music")
    @PostMapping("/music/all")
    public Result query(@RequestBody Music music){
        List<Music> list = musicService.query(music);
        return Result.ok(list);
    }

    @ApiOperation(value = "查询音乐信息",notes = "detail，根据id返回音乐信息")
    @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "int")
    @GetMapping("/music")
    public Result detail(@RequestParam("id") int id){
        Music music = musicService.detail(id);
        return Result.ok(music);
    }

    @ApiOperation(value = "计数",notes = "count，查询满足对应要求的数量")
    @ApiImplicitParam(name = "music", value = "音乐实体",dataType = "Music")
    @PostMapping("/music/count")
    public Result count(@RequestBody Music music){
        System.out.println(" t t t t.");
        int count = musicService.count(music);
        return Result.ok(count);
    }



    @ApiOperation(value = "提供最新的推荐音乐",notes = "不需要输入，直接给出最新音乐")
    @GetMapping("/music/new")
    public Result count(){
        Music music = musicService.newMusic();
        return Result.ok(music);
    }

}
