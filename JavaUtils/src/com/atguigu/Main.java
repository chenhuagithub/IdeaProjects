package com.atguigu;

import com.atguigu.lambda.MyFunction;

public class Main {

    public static void main(String[] args) {
        Integer res = operation(3, 5, (x, y) -> x + y);
        System.out.println(res);

        new Thread(() -> System.out.println("你好")).start();


    }

    public static Integer operation(int x, int y, MyFunction mf){
        return mf.add(x, y);
    }
}
