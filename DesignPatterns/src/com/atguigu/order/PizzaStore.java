package com.atguigu.order;

import com.atguigu.factory.SimpleFactory;

import java.util.Calendar;

public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();
//        orderPizza.setSimpleFactory(new SimpleFactory());
//        new OrderPizza(new SimpleFactory());
//        new BJOrderPizza();
        new OrderPizza(new BJFactory());
        Calendar instance = Calendar.getInstance();
    }

}
