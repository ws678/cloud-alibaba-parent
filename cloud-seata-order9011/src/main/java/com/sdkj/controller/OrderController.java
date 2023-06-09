package com.sdkj.controller;

import com.sdkj.entity.Order;
import com.sdkj.response.CommonResult;
import com.sdkj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangshuo
 * @Date 2022/5/30, 21:53
 * Please add a comment
 */
@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    // 调用示例
    // http://localhost:9011/order/create?userId=1&productId=1&count=10&money=100
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(1, "success");
    }
}
