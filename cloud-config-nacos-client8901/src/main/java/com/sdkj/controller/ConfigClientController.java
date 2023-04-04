package com.sdkj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangshuo
 * @Date 2022/5/28, 10:19
 * Please add a comment
 */
@RestController
//开启nacos自动刷新功能
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config/nacos/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
