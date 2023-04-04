package com.sdkj.service.impl;

import com.alibaba.fastjson.JSON;
import com.sdkj.service.TCCStorageService;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Service;

/**
 * @Author wangshuo
 * @Date 2022/6/1, 17:40
 * Please add a comment
 */
@Service
public class TCCStorageServiceImpl implements TCCStorageService {

    //try阶段
    @Override
    public Integer decrease(Long productId, Integer count) {
        /*
            新增
                到数据库一条状态为尝试的数据
            修改
                数据库设计时多加一个对应的冻结字段，try阶段修改先修改try对应字段
         */
        return null;
    }

    //commit阶段
    @Override
    public boolean addCommit(BusinessActionContext context) {
        //获取参数对象（Json格式）
        Object productId = context.getActionContext("productId");
        Long pid = JSON.parseObject(productId.toString(), Long.class);//也可以直接转化为实体类中的数据

        //提交到数据库
        return false;
    }

    //
    @Override
    public boolean addRollBack(BusinessActionContext context) {
        //获取参数对象（Json格式）
        Object productId = context.getActionContext("productId");
        Long pid = JSON.parseObject(productId.toString(), Long.class);//也可以直接转化为实体类中的数据

        /*
            新增
                删除对应数据
            修改
                将冻结字段置为0或初始值
         */
        return false;
    }
}
