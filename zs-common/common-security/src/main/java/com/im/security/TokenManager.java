package com.im.security;

import com.im.entity.SysUser;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:03
 * @apiNote token 工具类 采用jwt生成token信息
 */
public class TokenManager {
    /** token的有效时长 30分钟 */
    //@Value("token.expireTime")
    private Long EXPIRE_TIME = 1800000L;

    /** token 生成用的秘钥 */
    @Value("token.privateKey")
    private String PRIVATE_KEY;

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
        String userInfo = Jwts.parser()
                .setSigningKey(PRIVATE_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userInfo;
    }

    /**
     * 移除token信息
     * @param token 用户登录token
     */
    public void removeToken(String token){

    }

}
