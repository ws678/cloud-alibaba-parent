package com.sdkj.controller;

import com.sdkj.response.CommonResult;
import com.sdkj.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 9:18
 * Please add a comment
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public void decrease(@RequestParam("productId") Long productId ,@RequestParam("count") Integer count){

        storageService.decrease(productId, count);
    }
}
