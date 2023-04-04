package com.sdkj.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 9:46
 * Please add a comment
 */
@Mapper
public interface StorageMapper {
    public Integer decrease(Long productId, Integer count);
}
