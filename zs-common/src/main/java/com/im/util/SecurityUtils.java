package com.im.util;

import com.im.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
 * @author zhaojinhui
 * @date 2021/2/22 18:32
 * @apiNote
 */
public class SecurityUtils {

    public static SysUser getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        SysUser sysUser = new SysUser();
        sysUser.setId("test");
        return sysUser;
    }
}
