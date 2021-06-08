package com.consumer.service;


import com.consumer.Config.FeignTokenInterceptor;
import com.consumer.Config.MyFallbackFactory;
import com.consumer.entity.User;
import com.consumer.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 * 使用 feign客户端 绑定远程服务名称
 */
@FeignClient(name = "springcloud-service-user",
        fallbackFactory = MyFallbackFactory.class,configuration = FeignTokenInterceptor.class)
public interface UserService {

    @PostMapping("/user/create")
    public Result create(@RequestBody User user);

    @DeleteMapping("/user")
    public Result delete(@RequestParam int id);

    @PutMapping("/user")
    public Result update(@RequestBody User user);

    @GetMapping("/user/all")
    public Result query(@RequestBody User user);

    @GetMapping("/user")
    public Result detail(@RequestParam int id);

    @GetMapping("/user/count")
    public Result count(@RequestBody User user);

    @PostMapping("/login")
    public Result login(@RequestBody User user);

}
