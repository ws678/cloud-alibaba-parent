package com.sdkj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangshuo
 * @Date 2022/5/28, 15:25
 * Please add a comment
 */
@RestController
public class FlowLimitController {

    //测试熔断
    @GetMapping(value = "/testA")
    public String getA(){
        return "........testA";
    }

    //测试熔断
    @GetMapping(value = "/testB")
    public String getB(){
        return "........testB";
    }

    //测试降级自动发熔断
    @GetMapping(value = "/testD")
    public String getD(){
        return "........testD";
    }

    //测试热点限流
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey",fallback = "error_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1){
        System.out.println(Thread.currentThread().getName() + ".....testHotKey");
        return "........testHotKey";
    }

    //too Hot Handler
    public String deal_testHotKey(String p1){

        return "......deal_testHotKey";
    }

    //error Handler
    public String error_testHotKey(String p1){
        return "system error";
    }
}
