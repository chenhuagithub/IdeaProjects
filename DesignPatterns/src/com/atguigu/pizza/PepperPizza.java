package com.atguigu.pizza;

public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("为胡椒批萨准备原料");
    }
}
