package com.atguigu.适配器模式.类适配器;

public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        System.out.println("适配器进行适配");
        int src = output220V();
        int dis = src / 44;
        return dis;
    }
}
