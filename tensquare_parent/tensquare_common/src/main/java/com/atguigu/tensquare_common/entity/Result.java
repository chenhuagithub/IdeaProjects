package com.atguigu.tensquare_common.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// 无参构造方法
@NoArgsConstructor
// 有参构造方法
@AllArgsConstructor
public class Result<T> {

    private boolean flag;
    private Integer code;
    private String message;
    private T data;

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
