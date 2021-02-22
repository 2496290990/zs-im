package com.im;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaojinhui
 * @date 2021/2/20 11:15
 * @apiNote
 */
@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.im.mapper")
public class ClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class,args);
    }
}
