package com.im.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.SecurityUser;
import com.im.entity.User;
import com.im.security.TokenManager;
import com.im.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:02
 * @apiNote
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
    private TokenManager tokenManager;

    private RedisTemplate redisTemplate;

    private AuthenticationManager manager;

    /**
     * 获取表单提交过来的用户名和密码
     * @param request HTTP请求
     * @param response http相应
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),new ArrayList<>()));
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("登录异常");
        }
    }

    /**
     * 认证成功之后调用的方法
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //获取用户认证成功的信息
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        //根据用户名生成token
        String token = tokenManager.createToken(user.getCurrentUserInfo().getUsername());
        //吧用户名称和权限信息放在redis token中
        redisTemplate.opsForValue()
                .set(user.getCurrentUserInfo().getUsername(), user.getPermissionList());
        //返回token
        Map map = new HashMap<>(1);
        map.put("token", token);
        ResponseUtil.out(response, new Result(map));
    }

    /**
     * 认证失败的调用的方法
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ResponseUtil.out(response, ResultFactory.fail("认证失败"));
    }

    public TokenLoginFilter(TokenManager tokenManager, RedisTemplate redisTemplate, AuthenticationManager manager){
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.manager = manager;
        this.setPostOnly(false);
        //设置登录路径和提交方式
        this.setRequiresAuthenticationRequestMatcher(
            new AntPathRequestMatcher("/client/login","POST")
        );

    }


}
