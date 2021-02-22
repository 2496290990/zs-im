package com.im.service.impl;

import cn.hutool.extra.mail.MailUtil;
import com.im.controller.entity.Email;
import com.im.controller.util.EmailUtil;
import com.im.entity.Test;
import com.im.mapper.RegisterMapper;
import com.im.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author zhaojinhui
 * @date 2021/2/20 12:12
 * @apiNote
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private RegisterMapper registerMapper;

    /**
     * @param emailAddress 要注册的邮箱地址
     * @return 返回注册结果
     * @date  2021年2月20日12:14:31
     */
    @Override
    public String emailRegister(String emailAddress) throws Exception {
        Email email = new Email();
        email.setSendTo(emailAddress);
        email.setSubject("校友邦注册邮件");
        return emailUtil.sendEmail(email, true);
    }

    @Override
    public void test(Test test) {
        registerMapper.test(test);
    }

}
