package com.atguigu.pizza;

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给希腊批萨准备原材料");
    }
}
