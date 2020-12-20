package com.favorite.framework.mvc;

import com.favorite.framework.exception.MyException;
import com.favorite.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handle(RuntimeException exception){
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result handle(MyException exception){
        return Result.fail(exception.getMessage());
    }

}
