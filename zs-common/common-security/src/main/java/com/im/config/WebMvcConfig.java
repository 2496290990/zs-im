package com.im.config;

import com.im.security.DefaultPasswordEncoder;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojinhui
 * @date 2021/2/28 18:12
 * @apiNote
 */
@Configuration
public class WebMvcConfig extends WebMvcAutoConfiguration {

    @Bean
    public DefaultPasswordEncoder defaultPasswordEncoder(){
        return new DefaultPasswordEncoder();
    }

}
