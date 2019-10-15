package com.atguigu.bridge;

public class UpRightPhone extends Phone {

    public UpRightPhone(){

    }

    public UpRightPhone(Brand brand){
        this.brand = brand;
    }

    public void open(){
        super.open();
        System.out.println("直立手机");
    }

    public void close(){
        super.close();
        System.out.println("直立手机");
    }

    public void call(){
        super.call();
        System.out.println("直立手机");
    }


}
