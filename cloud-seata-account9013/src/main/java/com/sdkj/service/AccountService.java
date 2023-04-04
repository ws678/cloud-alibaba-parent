package com.sdkj.service;

import java.math.BigDecimal;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 15:01
 * Please add a comment
 */
public interface AccountService {
    Integer decrease(Long userId, BigDecimal money);
}
