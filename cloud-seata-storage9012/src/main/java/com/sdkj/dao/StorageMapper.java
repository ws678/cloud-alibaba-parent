package com.sdkj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 9:46
 * Please add a comment
 */
@Mapper
public interface StorageMapper {
    Integer decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
