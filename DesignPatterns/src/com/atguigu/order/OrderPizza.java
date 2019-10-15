package com.atguigu.order;

import com.atguigu.factory.AbsFactory;
import com.atguigu.factory.SimpleFactory;
import com.atguigu.pizza.CheesePizza;
import com.atguigu.pizza.GreekPizza;
import com.atguigu.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

//    SimpleFactory simpleFactory;

    Pizza pizza = null;

    String orderType = "";

    AbsFactory absFactory;

    public void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
    }

    public OrderPizza(AbsFactory absFactory){
        this.absFactory = absFactory;
        do{
            orderType = getTpye();
            // 抽象方法不能执行, 但是可以执行抽象方法的继承类
//            Pizza pizza = createPizza(orderType);
            System.out.println("orderType:"+orderType);
            System.out.println(this.absFactory);
            pizza = absFactory.createPizza(orderType);
            System.out.println(pizza);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                break;
            }
        }while (true);
    }


//    public abstract Pizza createPizza(String orderType);

    public String getTpye(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("pizza type:");
            String s = bufferedReader.readLine();
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }





}