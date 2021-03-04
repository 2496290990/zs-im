package com.im.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.im.entity.ImUser;
import com.im.entity.SysUser;
import com.im.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author zhaojinhui
 * @date 2021/3/1 21:16
 * @apiNote
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<ImUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("del_flag", "1");
        ImUser sysUser = userMapper.selectOne(wrapper);
        if(ObjectUtils.isEmpty(sysUser)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("user");
        return new User(sysUser.getUsername(), new BCryptPasswordEncoder().encode(sysUser.getPassword()), auth);
    }
}
