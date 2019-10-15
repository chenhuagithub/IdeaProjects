package com.atguigu.factory;

import com.atguigu.pizza.Pizza;

public interface AbsFactory {

    public Pizza createPizza(String orderType);


}
