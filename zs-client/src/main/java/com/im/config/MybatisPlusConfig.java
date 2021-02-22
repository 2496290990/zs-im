package com.im.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhaojinhui
 * @date 2021/2/21 15:39
 * @apiNote
 */
@MapperScan("com.im.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 乐观锁  配合 @Version 使用
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置请求的页面大于最后页后操作，true但会首页，false继续请求，默认false
        //paginationInterceptor.setOverflow(false);
        //设置单页最大数量，默认500，-1不做限制
        //paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }

    /**
     * 设置 dev test 环境开启 ，必须存在
     * @return
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //sql最大执行时间100ms ， 超时报错
        performanceInterceptor.setMaxTime(100);
        return  performanceInterceptor;
    }
}
