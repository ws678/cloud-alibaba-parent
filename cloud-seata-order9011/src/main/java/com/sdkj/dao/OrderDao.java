package com.sdkj.dao;

import com.sdkj.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wangshuo
 * @Date 2022/5/30, 21:56
 * Please add a comment
 */
@Mapper
public interface OrderDao {
    // 新建订单
    public int insert(Order order);

    // 更新订单 从0修改为1
    public Order update(@Param("id") Long id, @Param("userId") Long userId, @Param("status") Integer status);
}
