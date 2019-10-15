//package com.atguigu.order;
//
//import com.atguigu.pizza.BJChessPizza;
//import com.atguigu.pizza.BJGreekPizza;
//import com.atguigu.pizza.Pizza;
//
//public class BJOrderPizza extends OrderPizza {
//    @Override
//    public Pizza createPizza(String orderType) {
//        Pizza pizza = null;
//
//        if(orderType.equals("chess")){
//            pizza = new BJChessPizza();
//            pizza.setName("北京奶酪批萨");
//        }else if(orderType.equals("greek")){
//            pizza = new BJGreekPizza();
//            pizza.setName("北京奶酪批萨");
//        }
//
//        return pizza;
//    }
//}
