package com.atguigu.tensquarebase.controller;

import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage(), null);
    }

}
