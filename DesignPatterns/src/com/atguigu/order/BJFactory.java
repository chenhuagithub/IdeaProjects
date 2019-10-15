package com.atguigu.order;

import com.atguigu.factory.AbsFactory;
import com.atguigu.pizza.BJChessPizza;
import com.atguigu.pizza.BJGreekPizza;
import com.atguigu.pizza.Pizza;

public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new BJGreekPizza();
            pizza.setName("北京希腊批萨");

        }else if(orderType.equals("cheese")){
            pizza = new BJChessPizza();
            pizza.setName("北京奶酪批萨");
        }

        return pizza;
    }
}
