package com.atguigu.bridge;

public abstract class Phone {

    public Brand brand;

    public Phone(){

    }

    public Phone(Brand brand){
        super();
        this.brand = brand;
    }

    public void open(){
        brand.open();
    }

    public void close(){
        brand.close();
    }

    public void call(){
        brand.call();
    }

}
