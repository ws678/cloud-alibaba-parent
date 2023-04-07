package com.sdkj.service.impl;

import com.sdkj.dao.OrderDao;
import com.sdkj.entity.Order;
import com.sdkj.service.AccountService;
import com.sdkj.service.OrderService;
import com.sdkj.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wangshuo
 * @Date 2022/5/30, 22:06
 * Please add a comment
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Transactional
    @GlobalTransactional//全局事务控制
    @Override
    public void create(Order order) {
        if (null != order.getCount() & null != order.getMoney() & null != order.getUserId() & null != order.getProductId()) {
            System.out.println("create start");
            //创建进行中的订单
            orderDao.insert(order);
            //减库存
            storageService.decrease(order.getProductId(), order.getCount());
            System.out.println("storage decrease success");
            //扣减余额
            accountService.decrease(order.getUserId(), order.getMoney());
            System.out.println("order decrease success");
            //修改订单状态
            orderDao.update(order.getId(), order.getUserId());
            //end
            System.out.println("end");
        } else {
            throw new RuntimeException("请传入必须的参数");
        }
    }
}
