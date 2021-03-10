package com.im.security;

import com.im.entity.SysUser;
import com.im.util.SpringUtil;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:03
 * @apiNote token 工具类 采用jwt生成token信息
 */
@Component
public class TokenManager {
    /** token的有效时长 30分钟 */
    //@Value("token.expireTime")
    private Long EXPIRE_TIME = 1800000L;

    /** token 生成用的秘钥 */
    @Value("token.privateKey")
    private String PRIVATE_KEY;
    @Autowired
    private RedisTemplate redisTemplate ;//= SpringUtil.getBean(RedisTemplate.class);

    /**
     * 根据用户名生成token
     * @param username 用户名
     * @return
     */
    public String createToken(String username){
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS512,PRIVATE_KEY)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    /**
     * 通过token获取用户信息
     * @param token
     * @return
     */
    public String getUserInfo(String token){
        /*String userInfo = Jwts.parser()
                .setSigningKey("elevenZ")
                .parseClaimsJws(token)
                .getBody()
                .getSubject();*/
        String userInfo = redisTemplate.opsForValue()
                .get(token).toString();
        return userInfo;
    }



    /**
     * 移除token信息
     * @param token 用户登录token
     */
    public void removeToken(String token){

    }

}
