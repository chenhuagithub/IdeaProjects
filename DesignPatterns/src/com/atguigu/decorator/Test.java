package com.atguigu.decorator;

public class Test {
    public static void main(String[] args) {

        Drink order = new LongBladk();
        System.out.println(order.cost());
        Decorator chocolate = new Chocolate(order);
        System.out.println(chocolate.cost());
    }
}
