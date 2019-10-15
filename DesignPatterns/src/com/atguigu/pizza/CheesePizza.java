package com.atguigu.pizza;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给奶酪批萨准备原材料");
    }
}
