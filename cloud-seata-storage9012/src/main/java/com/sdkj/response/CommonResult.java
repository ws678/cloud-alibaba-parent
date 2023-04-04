package com.sdkj.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wangshuo
 * @Date 2022/5/30, 21:57
 * Please add a comment
 */
@Data
@AllArgsConstructor //初始值
@NoArgsConstructor //提供构造方法
public class CommonResult<T> {

    private int code;
    private String msg;
    private T data;

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
