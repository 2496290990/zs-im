package com.im.security;

import cn.hutool.crypto.SecureUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:03
 * @apiNote
 */

public class DefaultPasswordEncoder  implements PasswordEncoder {

    /**
     * 加密传过来的密码字符串
     * @param charSequence 明文密码
     * @return String 加密后的密码
     */
    @Override
    public String encode(CharSequence charSequence) {
        return SecureUtil.md5(charSequence.toString());
    }

    /**
     * 验证传入的明文密码与加密后的密码是否一致
     * @param charSequence 明文密码
     * @param encode 加密后的密文
     * @return Boolean 返回校验结果
     */
    @Override
    public boolean matches(CharSequence charSequence, String encode) {
        return encode.equals(charSequence.toString());
    }
}
