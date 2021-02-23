package com.im.controller;

import com.im.common.Result;
import com.im.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojinhui
 * @date 2021/2/22 18:24
 * @apiNote
 */
@RestController
@RequestMapping("/login")
@Api("登录")
public class LoginController {

    @PostMapping("/sign")
    public Result userSign(@RequestBody User user){
        return null;
    }
}
