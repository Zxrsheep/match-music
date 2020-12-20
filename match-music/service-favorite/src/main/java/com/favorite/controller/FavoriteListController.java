package com.favorite.controller;

import com.favorite.entity.FavoriteList;
import com.favorite.framework.exception.MyException;
import com.favorite.service.FavoriteListService;
import com.favorite.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "收藏夹操作接口，注意仍然需要token")
public class FavoriteListController {

    @Autowired
    private FavoriteListService favoriteListService;


    @ApiOperation(value = "新建收藏表",notes = "填user_id和name(收藏夹名称)")
    @ApiImplicitParam(name = "favoriteList", value = "收藏夹实体",required = true,dataType = "FavoriteList")
    @PostMapping("/favoriteList")
    public Result create(@RequestBody FavoriteList favoriteList){
        if (favoriteListService.create(favoriteList) == 1){
            return Result.ok();
        }
        else {
            throw new MyException("我也不知道为什么会有问题...");
        }
    }

    @ApiOperation(value = "收藏夹",notes = "根据id删除收藏夹")
    @ApiImplicitParam(name = "id", value = "收藏夹id",required = true,dataType = "int")
    @DeleteMapping("/favoriteList")
    public Result delete(@RequestParam("id") int id){
        return Result.ok(favoriteListService.delete(id));
    }


    @ApiOperation(value = "更新收藏夹",notes = "update,根据id来更新信息，填写id以及需要更新的信息(name)")
    @ApiImplicitParam(name = "favoriteList", value = "收藏夹实体",required = true,dataType = "FavoriteList")
    @PutMapping("/favoriteList")
    public Result update(@RequestBody FavoriteList favoriteList){
        return Result.ok(favoriteListService.update(favoriteList));
    }


    @ApiOperation(value = "查询收藏夹",notes = "query查询，查询返回满足要求的所有list(可用于列出对应用户id的所有收藏夹等)")
    @ApiImplicitParam(name = "favoriteList", value = "收藏夹实体",dataType = "FavoriteList")
    @PostMapping("/favoriteList/all")
    public Result query(@RequestBody FavoriteList favoriteList){
        List<FavoriteList> list = favoriteListService.query(favoriteList);
        return Result.ok(list);
    }

    @ApiOperation(value = "根据id查询收藏夹信息",notes = "detail，根据id返回收藏夹信息(不一定好用)，只会返回一个结果！！")
    @ApiImplicitParam(name = "id", value = "收藏夹id",required = true,dataType = "int")
    @GetMapping("/favoriteList")
    public Result detail(@RequestParam("id") int id){
        FavoriteList favoriteList = favoriteListService.detail(id);
        return Result.ok(favoriteList);
    }

    @ApiOperation(value = "计数",notes = "根据对应收藏夹id返回歌曲数量")
    @ApiImplicitParam(name = "favorite_id", value = "收藏夹实体",dataType = "int")
    @GetMapping("/favoriteList/count")
    public Result count(@RequestParam("favorite_id") int favorite_id){
        System.out.println(" t t t t.");
        int count = favoriteListService.count(favorite_id);
        return Result.ok(count);
    }

}
