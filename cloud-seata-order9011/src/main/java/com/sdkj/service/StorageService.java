package com.sdkj.service;

import com.sdkj.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author wangshuo
 * @Date 2022/5/30, 21:59
 * Please add a comment
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    void decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
