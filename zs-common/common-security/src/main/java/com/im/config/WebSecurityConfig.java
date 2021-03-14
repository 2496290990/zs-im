package com.im.config;

import com.im.filter.TokenAuthenticationFilter;
import com.im.filter.TokenLoginFilter;
import com.im.security.DefaultPasswordEncoder;
import com.im.security.TokenLogoutHandler;
import com.im.security.TokenManager;
import com.im.security.UnauthHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhaojinhui
 * @date 2021/2/28 16:59
 * @apiNote
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DefaultPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

   /* @Autowired
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                /*.loginPage("/login")
                .loginProcessingUrl("/login")*/
                .and()
                .authorizeRequests()
                .antMatchers("/login","/login.html").permitAll()
                .antMatchers("/circleOfFriend/**").permitAll()
                .antMatchers("/**/**").permitAll()
//                .antMatchers("/**").authenticated()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/client/logout")
                .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate))
                .and()
                //添加过滤器
                .addFilter(new TokenAuthenticationFilter(authenticationManager()))
                .addFilter(new TokenLoginFilter(tokenManager, redisTemplate, authenticationManager()))
                .exceptionHandling()
                //没有权限调用的处理器
                .authenticationEntryPoint(new UnauthHandler())
                .and().csrf().disable()
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
