package com.atguigu.适配器模式.类适配器;

public class Phone {


    public void charging(Voltage5V voltage5V){
        if (voltage5V.output5V() == 5){
            System.out.println("电压为5v, 可以冲电");
        }else {
            System.out.println("电压大于5v, 不能充电");
        }

    }


}
