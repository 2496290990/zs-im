package com.im.utils;

import com.im.entity.SysUser;

import java.util.Collection;

/**
 * @author zhaojinhui
 * @date 2021/2/22 18:32
 * @apiNote
 */
public class SecurityUtils {

    public static SysUser getUserInfo(){
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();*/
        SysUser sysUser = new SysUser();
        sysUser.setId("2496290990");
        return sysUser;
    }
}
