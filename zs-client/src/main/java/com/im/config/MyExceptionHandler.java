package com.im.config;

import com.im.common.Result;
import com.im.common.ResultFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhaojinhui
 * @date 2021/2/20 12:18
 * @apiNote
 * */


@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        return ResultFactory.throwException(e);
    }
}
