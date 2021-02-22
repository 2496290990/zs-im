package com.im.common;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应信息主体
 */
@Data
@ToString
public class Result<T> implements Serializable {
    private static final int SUCCESS = 200;
    private static final int FAIL = 500;
    private static final long serialVersionUID = 1L;

    private String msg = "success";


    private int code = SUCCESS;

    private T data;

    public Result() {
        super();
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public Result(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public Result(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    public Result(int code, String msg,T data) {
        super();
        this.data = data;
        this.msg = msg;
        this.code = code;
    }


}

