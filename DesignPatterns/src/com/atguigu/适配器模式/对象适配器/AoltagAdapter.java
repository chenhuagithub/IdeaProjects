package com.atguigu.适配器模式.对象适配器;

public class AoltagAdapter implements Aoltag5V {

    private Aoltag220V aoltag220V;

    public AoltagAdapter() {
    }

    public AoltagAdapter(Aoltag220V aoltag220V) {
        this.aoltag220V = aoltag220V;
    }

    @Override
    public int output() {
        System.out.println("适配器进行适配");
        int src = this.aoltag220V.output();
        int dis = src /44;
        return dis;
    }
}
