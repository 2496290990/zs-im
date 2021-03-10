package com.im.filter;

import com.alibaba.fastjson.JSONObject;
import com.im.entity.SecurityUser;
import com.im.security.TokenManager;
import com.im.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:47
 * @apiNote
 */

public class TokenAuthenticationFilter extends BasicAuthenticationFilter {

    private TokenManager tokenManager = SpringUtil.getBean(TokenManager.class);
    private RedisTemplate redisTemplate ;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取用户信息
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        //如果token中的用户信息不为空的话，放进权限上下文中
        if(authentication != null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        //从header中获取token信息
        String token = request.getHeader("Authorization");
        if(token != null) {
            String userInfo = tokenManager.getUserInfo(token);
            SecurityUser user = JSONObject.parseObject(userInfo, SecurityUser.class);
            /*List<String> permissionList = (List)redisTemplate.opsForValue().get(userInfo);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            permissionList.stream().forEach(per -> {
                authorities.add(new SimpleGrantedAuthority(per));
            });*/
            //return new UsernamePasswordAuthenticationToken(userInfo, token, authorities);
            return new UsernamePasswordAuthenticationToken(user.getUsername(), token, user.getAuthorities());

        }
        return null;
    }
}
