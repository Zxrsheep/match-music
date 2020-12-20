package com.consumer.service;

import com.consumer.Config.FeignTokenInterceptor;
import com.consumer.Config.MyFallbackFactory;
import com.consumer.entity.Notice;
import com.consumer.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "springcloud-service-user",fallbackFactory = MyFallbackFactory.class,configuration = FeignTokenInterceptor.class)
public interface NoticeService {

    @PostMapping("/notice")
    public Result create(@RequestBody Notice notice);

    @DeleteMapping("/notice")
    public Result delete(@RequestParam int id);

    @PutMapping("/notice")
    public Result update(@RequestBody Notice notice);

    @GetMapping("/notice")
    public Result query(@RequestParam int id);

}
