package com.im.controller;

import com.im.controller.common.Result;
import com.im.entity.Test;
import com.im.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaojinhui
 * @date 2021/2/20 11:02
 * @apiNote
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/emailRegister/{email}")
    public Result emailRegister(@PathVariable("email") String email) throws Exception {
        String code = registerService.emailRegister(email);
        return new Result(code);
    }

    @PostMapping("/test")
    public Result test(@RequestBody Test test){
        registerService.test(test);
        return null;
    }
}
