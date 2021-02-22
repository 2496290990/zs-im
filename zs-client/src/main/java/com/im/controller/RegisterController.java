package com.im.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.StrUtil;
import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.VerifyLog;
import com.im.service.RegisterService;
import com.im.service.UserService;
import com.im.service.VerifyLogService;
import com.im.util.SnowFlake;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaojinhui
 * @date 2021/2/20 11:02
 * @apiNote
 */
@RestController
@RequestMapping("/register")
@Api(tags = "用户注册控制器")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserService userService;

    @Autowired
    private VerifyLogService verifyLogService;

    /**
     * 发送注册用验证码
     * @param verifyLog 验证码实体类，registerAccount必填
     * @return
     * @throws Exception
     */
    @PostMapping("/sendEmail")
    @ApiOperation(value = "发送注册邮件",notes = "发送注册所用的验证码，并存库处理，registerAccount 字段必填")
    public Result emailRegister(@RequestBody VerifyLog verifyLog) throws Exception {

        String code = registerService.emailRegister(verifyLog.getRegisterAccount());
        if(!StrUtil.equals(code,"false")){
            verifyLog.setVerifyCode(code);
            verifyLogService.saveEmailCode(verifyLog);
        }
        return ResultFactory.success(code);
    }

    /**
     * 根据注册填写的手机号或者是邮箱，判断该账号是否已经注册过了
     * @param subject 要注册的账号主体
     * @return
     */
    @GetMapping("/verifySame/{subject}")
    @ApiOperation(value = "校验手机号或者邮箱是否注册过",notes = "校验手机号是否被注册过")
    public Result verifySame(@PathVariable("subject") String subject){
        return userService.verifySameByRegisterSubject(subject);
    }
}
