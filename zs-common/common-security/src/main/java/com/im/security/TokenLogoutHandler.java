package com.im.security;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:21
 * @apiNote 用户退出并删除token信息
 */
public class TokenLogoutHandler implements LogoutHandler {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TokenManager tokenManager;

    public TokenLogoutHandler(TokenManager tokenManager,RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.tokenManager = tokenManager;
    }

    /**
     * 用户退出并且移除token
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //1.从header中获取token信息
        String token = request.getHeader("token");
        if(StrUtil.isNotEmpty(token)){
            tokenManager.removeToken(token);
            String userInfo = tokenManager.getUserInfo(token);
            redisTemplate.delete(userInfo);
        }

    }
}
