package com.sdkj.service.impl;

import com.sdkj.dao.OrderDao;
import com.sdkj.entity.Order;
import com.sdkj.service.AccountService;
import com.sdkj.service.OrderService;
import com.sdkj.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wangshuo
 * @Date 2022/5/30, 22:06
 * Please add a comment
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    //全局事务控制
    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        System.out.println("create start");
        //减库存
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("storage decrease success");
        //扣减余额
        accountService.decrease(order.getUserId(), order.getMoney());
        System.out.println("order decrease success");
        //修改订单状态
        orderDao.update(order.getId(), order.getUserId(), 0);
        //end
        System.out.println("end");
    }
}
