package com.sdkj.service.impl;

import com.sdkj.dao.AccountMapper;
import com.sdkj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 15:12
 * Please add a comment
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Integer decrease(Long userId, BigDecimal money) {
        return accountMapper.decrease(userId,money);
    }
}
