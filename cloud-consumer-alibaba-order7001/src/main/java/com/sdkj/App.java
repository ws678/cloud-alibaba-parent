package com.sdkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author wangshuo
 * @Date 2022/5/28, 9:49
 * Please add a comment
 */
//服务注册与发现
@EnableDiscoveryClient
@SpringBootApplication
//开启feign
@EnableFeignClients
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
