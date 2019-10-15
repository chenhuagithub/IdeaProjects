package com.atguigu.适配器模式.对象适配器;

public class Phone {

    public void charging(Aoltag5V aoltag5V){
        int i = aoltag5V.output();
        if (i == 5){
            System.out.println("电压为5v, 可以充电");
        }else {
            System.out.println("电压不为5v, 不能充电");
        }
    }


}
