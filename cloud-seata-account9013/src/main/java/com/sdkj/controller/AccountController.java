package com.sdkj.controller;

import com.sdkj.response.CommonResult;
import com.sdkj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 14:59
 * Please add a comment
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money){
        Integer count = accountService.decrease(userId,money);
        if (count>0)
            return new CommonResult<>(200,"余额扣减成功，影响条数"+count.toString());
        else
            throw new RuntimeException("对应账户余额不足！");
    }
}
