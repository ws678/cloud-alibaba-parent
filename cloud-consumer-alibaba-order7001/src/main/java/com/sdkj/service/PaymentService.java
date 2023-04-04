package com.sdkj.service;

import com.sdkj.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wangshuo
 * @Date 2022/5/29, 13:19
 * Please add a comment
 */
@FeignClient(value = "alibaba-sentinel-service",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/testB")
    public String getB();
}
