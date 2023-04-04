package com.sdkj.service.impl;

import com.sdkj.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author wangshuo
 * @Date 2022/5/29, 13:22
 * Please add a comment
 */
@Component
public class PaymentFallbackService implements PaymentService {

    public String getB() {
        String a = "服务降级返回";
        return a;
    }
}
