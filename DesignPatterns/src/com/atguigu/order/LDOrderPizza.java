//package com.atguigu.order;
//
//import com.atguigu.pizza.*;
//
//public class LDOrderPizza extends OrderPizza {
//    @Override
//    public Pizza createPizza(String orderType) {
//        Pizza pizza = null;
//
//        if(orderType.equals("chess")){
//            pizza = new LDChessPizza();
//            pizza.setName("伦敦希腊批萨");
//        }else if(orderType.equals("greek")){
//            pizza = new LDGreekPizza();
//            pizza.setName("伦敦希腊批萨");
//        }
//
//        return pizza;
//    }
//}
