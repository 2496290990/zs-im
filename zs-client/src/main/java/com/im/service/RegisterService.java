package com.im.service;

import com.im.entity.Test;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author zhaojinhui
 * @date 2021/2/20 12:11
 * @apiNote
 */

public interface RegisterService {

    /**
     * 使用邮箱进行注册
     * @param email 邮箱地址
     */
    String emailRegister(String email) throws Exception;

    void test(Test test);
}
