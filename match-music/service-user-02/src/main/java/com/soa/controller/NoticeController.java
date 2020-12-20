package com.soa.controller;

import com.soa.entity.Notice;
import com.soa.framework.exception.MyException;
import com.soa.service.NoticeService;
import com.soa.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "创建公告",notes = "create,对应公告创建的接口。")
    @ApiImplicitParam(name = "notice", value = "公告实体",required = true,dataType = "Notice")
    @PostMapping("/notice")
    public Result create(@RequestBody Notice notice){
        if (noticeService.create(notice) == 1){
            return Result.ok(1);
        }
        else {
            throw new MyException("错误！！！");
        }
    }

    @ApiOperation(value = "删除公告",notes = "delete，使用id删除")
    @ApiImplicitParam(name = "id", value = "公告id",required = true,dataType = "int")
    @DeleteMapping("/notice")
    public Result delete(@RequestParam("id") int id){
        return Result.ok(noticeService.delete(id));
    }


    @ApiOperation(value = "更新公告信息",notes = "update，id必填，date可以自动更新，不用填写")
    @ApiImplicitParam(name = "notice", value = "公告实体",required = true,dataType = "Notice")
    @PutMapping("/notice")
    public Result update(@RequestBody Notice notice){
        return Result.ok(noticeService.update(notice));
    }

    @ApiOperation(value = "查询用户信息",notes = "detail，查询对应id的单个用户的信息")
    @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "int")
    @GetMapping("/notice")
    public Result detail(@RequestParam("id") int id){
        Notice notice = new Notice();
        notice.setId(id);
        List<Notice> notice1 = noticeService.query(notice);
        return Result.ok(notice1);
    }

}
