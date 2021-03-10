package com.im.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojinhui
 * @date 2021/2/22 18:24
 * @apiNote
 */
@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;

   /* @PostMapping("/login")
    public Result login(@RequestBody ImUser user){
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return null;
    }*/
}
