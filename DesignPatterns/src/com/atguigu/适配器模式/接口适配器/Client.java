package com.atguigu.适配器模式.接口适配器;

public class Client {
    public static void main(String[] args) {

        AbsAdapter absAdapter = new AbsAdapter(){

            public void m1(){
                System.out.println("我实现了m1的方法");
            }
        };
        absAdapter.m1();
        absAdapter.m2();
    }
}
