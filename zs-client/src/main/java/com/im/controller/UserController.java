package com.im.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.im.common.Result;
import com.im.entity.User;
import com.im.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public Result getPage(Page page, User user){
        IPage<User> userPage =  userService.selectUserPageByLike(page,user);
        return new Result(userPage);
    }
}

