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
    public CommonResult decrease(@RequestParam("productId") Long productId ,@RequestParam("count") Integer count){

        Integer decrease = storageService.decrease(productId, count);
        if (decrease>0)
            return new CommonResult<>(200,"修改成功，影响条数="+decrease.toString());
        else
            throw new RuntimeException("商品对应库存不足");
    }
}
