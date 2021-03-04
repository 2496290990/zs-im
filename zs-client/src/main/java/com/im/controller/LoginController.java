package com.im.controller;

import com.im.common.Result;
import com.im.entity.ImUser;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojinhui
 * @date 2021/2/22 18:24
 * @apiNote
 */
@RestController
@Api(tags = "登录")
public class LoginController {

    @PostMapping("/login")
    public Result userSign(@RequestBody ImUser imUser){

        return null;
    }


}
