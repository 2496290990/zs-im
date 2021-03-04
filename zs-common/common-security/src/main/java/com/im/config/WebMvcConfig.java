package com.im.config;

import com.im.security.DefaultPasswordEncoder;
import com.im.security.TokenManager;
import io.lettuce.core.dynamic.RedisCommandFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zhaojinhui
 * @date 2021/2/28 18:12
 * @apiNote
 */
@Configuration
public class WebMvcConfig extends WebMvcAutoConfiguration {

    @Bean
    public TokenManager tokenManager(){
        return new TokenManager();
    }

    /*@Bean
    public RedisTemplate redisTemplate(){
        return new RedisTemplate(RedisConnectionFactory);
    }*/

    @Bean
    public DefaultPasswordEncoder defaultPasswordEncoder(){
        return new DefaultPasswordEncoder();
    }
}
