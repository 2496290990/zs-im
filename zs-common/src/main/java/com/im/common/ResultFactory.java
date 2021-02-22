package com.im.common;

import cn.hutool.http.HttpStatus;

/**
 * @author zhaojinhui
 * @date 2021/2/22 11:12
 * @apiNote
 */
public class ResultFactory {

    private static final String SUCCESS = "success";

    private static final String FAIL = "fail";

    public static Result success(Object data){
        return new Result(HttpStatus.HTTP_OK,SUCCESS,data);
    }

    public static Result fail(Object data){
        return new Result(HttpStatus.HTTP_INTERNAL_ERROR, FAIL, data);
    }

    public static Result buildResult(int code,String msg,Object data){
        return new Result(code,msg,data);
    }

    public static Result throwException(Throwable t){
        return new Result(t);
    }
}
