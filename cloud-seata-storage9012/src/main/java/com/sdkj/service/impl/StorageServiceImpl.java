package com.sdkj.service.impl;

import com.sdkj.dao.StorageMapper;
import com.sdkj.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wangshuo
 * @Date 2022/5/31, 9:42
 * Please add a comment
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public Integer decrease(Long productId, Integer count) {
        return storageMapper.decrease(productId, count);
    }
}
