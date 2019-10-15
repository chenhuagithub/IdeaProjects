package com.atguigu.logindemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
