package com.im.filter;

import com.im.security.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

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

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
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
        String token = request.getHeader("token");
        if(token != null) {
            String userInfo = tokenManager.getUserInfo(token);
            List<String> permissionList = (List)redisTemplate.opsForValue().get(userInfo);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            permissionList.stream().forEach(per -> {
                authorities.add(new SimpleGrantedAuthority(per));
            });
            return new UsernamePasswordAuthenticationToken(userInfo, token, authorities);
        }
        return null;
    }
}
