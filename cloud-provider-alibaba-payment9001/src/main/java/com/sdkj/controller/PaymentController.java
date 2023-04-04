package com.sdkj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangshuo
 * @Date 2022/5/28, 9:26
 * Please add a comment
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/getPort/{id}")
    public String getPort(@PathVariable("id") Integer id) {
        return "id = "+id+ " port = " + port;
    }
}
