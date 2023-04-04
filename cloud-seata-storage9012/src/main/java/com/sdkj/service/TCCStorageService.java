package com.sdkj.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @Author wangshuo
 * @Date 2022/6/1, 17:34
 * TCC模式
 * 接口被seata管理 根据事务的状态完成提交或回滚的操作
 */
@LocalTCC
public interface TCCStorageService {

    @TwoPhaseBusinessAction(name = "StorageTcc",commitMethod = "addCommit",rollbackMethod = "addRollBack")
    Integer decrease(@BusinessActionContextParameter(paramName = "productId") Long productId,
                     @BusinessActionContextParameter(paramName = "count") Integer count);

    public boolean addCommit(BusinessActionContext context);

    public boolean addRollBack(BusinessActionContext context);
}
