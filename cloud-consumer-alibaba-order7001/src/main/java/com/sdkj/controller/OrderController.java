package com.sdkj.controller;

import com.sdkj.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wangshuo
 * @Date 2022/5/28, 9:51
 * Please add a comment
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentService paymentService;

    //通过restTemplate调用
    @GetMapping(value = "/consumer/nacos/getPaymentPort/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://nacos-payment-provider" + "/payment/nacos/getPort/" + id, String.class);
    }

    //通过openFeign调用
    @GetMapping(value = "/consumer/feign/getSentinelB")
    public String getB(){
        return paymentService.getB();
    }
}
