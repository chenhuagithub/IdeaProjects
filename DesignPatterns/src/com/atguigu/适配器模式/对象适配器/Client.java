package com.atguigu.适配器模式.对象适配器;

import com.atguigu.适配器模式.类适配器.Voltage220V;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        AoltagAdapter aoltagAdapter = new AoltagAdapter(new Aoltag220V());
        phone.charging(aoltagAdapter);
    }
}
