package com.tao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 16:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
