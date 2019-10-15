package com.atguigu.order;

import com.atguigu.factory.AbsFactory;
import com.atguigu.pizza.LDChessPizza;
import com.atguigu.pizza.LDGreekPizza;
import com.atguigu.pizza.Pizza;

public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new LDGreekPizza();
            pizza.setName("伦敦希腊批萨");
        }else if(orderType.equals("cheese")){
            pizza = new LDChessPizza();
            pizza.setName("伦敦奶酪批萨");
        }
        return pizza;
    }
}
