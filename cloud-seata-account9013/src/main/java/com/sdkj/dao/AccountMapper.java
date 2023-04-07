package com.sdkj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 15:13
 * Please add a comment
 */
@Mapper
public interface AccountMapper {
    Integer decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
