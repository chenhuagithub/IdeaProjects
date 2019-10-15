package com.atguigu.Utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ColletionException {



    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String handleException01(){
        System.out.println("出错了老铁");
        return "error";

    }


}
