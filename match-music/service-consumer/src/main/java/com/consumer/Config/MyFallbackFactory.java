package com.consumer.Config;

import com.consumer.entity.User;
import com.consumer.service.UserService;
import com.consumer.utils.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {

            @Override
            public Result create(User user) {
                return Result.fail(throwable.getMessage());
            }

            @Override
            public Result delete(int id) {
                return Result.fail(throwable.getMessage());
            }

            @Override
            public Result update(User user) {
                return Result.fail(throwable.getMessage());
            }

            @Override
            public Result query(User user) {
                return Result.fail(throwable.getMessage());
            }

            @Override
            public Result detail(int id) {
                return Result.fail(throwable.getMessage());
            }

            @Override
            public Result count(User user) {
                return Result.fail(throwable.getMessage());
            }

            @Override
            public Result login(User user) {
                return Result.fail(throwable.getMessage());
            }
        } ;
    }

}
