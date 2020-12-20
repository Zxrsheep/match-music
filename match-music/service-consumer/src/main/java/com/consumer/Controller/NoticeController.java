package com.consumer.Controller;

import com.consumer.entity.Notice;
import com.consumer.service.NoticeService;
import com.consumer.utils.Result;
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
        return noticeService.create(notice);
    }

    @ApiOperation(value = "删除公告",notes = "delete，使用id删除")
    @ApiImplicitParam(name = "id", value = "公告id",required = true,dataType = "int")
    @DeleteMapping("/notice")
    public Result delete(@RequestParam("id") int id){
        return noticeService.delete(id);
    }


    @ApiOperation(value = "更新公告信息",notes = "update，id必填，date可以自动更新，不用填写")
    @ApiImplicitParam(name = "notice", value = "公告实体",required = true,dataType = "Notice")
    @PutMapping("/notice")
    public Result update(@RequestBody Notice notice){
        return noticeService.update(notice);
    }

    @ApiOperation(value = "查询公告信息",notes = "query，查询对应id的单个公告的信息")
    @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "int")
    @GetMapping("/notice")
    public Result query(@RequestParam("id") int id){
        return noticeService.query(id);
    }

}
