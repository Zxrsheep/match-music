package com.favorite.controller;

import com.favorite.entity.FavoriteMusic;
import com.favorite.framework.exception.MyException;
import com.favorite.service.FavoriteMusicService;
import com.favorite.utils.Maps;
import com.favorite.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "收藏夹音乐操作接口，注意仍然需要token")
public class FavoriteMusicController {

    @Autowired
    private FavoriteMusicService favoriteMusicService;


    @ApiOperation(value = "向收藏夹添加推荐音乐",notes = "必填：收藏夹id(favorite_id),音乐id(music_id),date不需要填写")
    @ApiImplicitParam(name = "favoriteMusic", value = "收藏音乐实体",required = true,dataType = "FavoriteMusic")
    @PostMapping("/favoriteMusic")
    public Result create(@RequestBody FavoriteMusic favoriteMusic){
        if (favoriteMusicService.create(favoriteMusic) == 1){
            return Result.ok();
        }
        else {
            throw new MyException("我也不知道为什么会有问题...注意检查两个id主键");
        }
    }

    @ApiOperation(value = "删除收藏夹音乐",notes = "根据收藏夹id(favorite_id),音乐id(music_id)来删除收藏的音乐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "favorite_id", value = "收藏夹id",required = true,dataType = "int"),
            @ApiImplicitParam(name = "music_id", value = "音乐id",required = true,dataType = "int")
    })
    @DeleteMapping("/favoriteMusic")
    public Result delete(@RequestParam("favorite_id") int favorite_id ,@RequestParam("music_id") int music_id){
        return Result.ok(favoriteMusicService.delete(favorite_id,music_id));
    }


    @ApiOperation(value = "更新收藏夹音乐",notes = "update")
    @ApiImplicitParam(name = "favoriteMusic", value = "收藏音乐实体",required = true,dataType = "FavoriteMusic")
    @PutMapping("/favoriteMusic")
    public Result update(@RequestBody FavoriteMusic favoriteMusic){
        return Result.ok(favoriteMusicService.update(favoriteMusic));
    }


    @ApiOperation(value = "查询信息",notes = "query查询，根据收藏夹id查询并返回收藏夹内的所有音乐")
    @ApiImplicitParam(name = "favorite_id", value = "收藏夹id",dataType = "int")
    @GetMapping("/favoriteMusic")
    public Result query(@RequestParam int favorite_id){
        FavoriteMusic favoriteMusic = new FavoriteMusic();
        favoriteMusic.setFavorite_id(favorite_id);
        List<FavoriteMusic> list = favoriteMusicService.query(favoriteMusic);
        return Result.ok(list);
    }

    @ApiOperation(value = "查询详细音乐",notes = "detail，特定查询某一首歌，不知道有没有用...")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "favorite_id", value = "收藏夹id",required = true,dataType = "int"),
            @ApiImplicitParam(name = "music_id", value = "音乐id",required = true,dataType = "int")
    })
    @GetMapping("/favoriteMusicDetail")
    public Result detail(@RequestParam("favorite_id") int favorite_id ,@RequestParam("music_id") int music_id){
        FavoriteMusic favoriteMusic = new FavoriteMusic();
        favoriteMusic.setFavorite_id(favorite_id);
        favoriteMusic.setMusic_id(music_id);
        List<FavoriteMusic> list = favoriteMusicService.query(favoriteMusic);
        return Result.ok(list);
    }

}
