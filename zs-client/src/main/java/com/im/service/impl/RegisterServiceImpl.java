package com.im.service.impl;

import com.im.entity.Email;
import com.im.entity.Test;
import com.im.mapper.RegisterMapper;
import com.im.service.RegisterService;
import com.im.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String emailRegister(String emailAddress){
        Email email = new Email();
        email.setSendTo(emailAddress);
        email.setSubject("校友邦注册邮件");
        try{
            return emailUtil.sendEmail(email, true);
        }catch(Exception e){
            e.printStackTrace();
            return "false";
        }

    }

    @Override
    public void test(Test test) {
        registerMapper.test(test);
    }

}
