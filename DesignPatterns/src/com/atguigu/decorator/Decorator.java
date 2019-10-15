package com.atguigu.decorator;

public class Decorator extends Drink {

    private Drink obj;

    public Decorator(){

    }

    public Decorator(Drink obj){
        this.obj = obj;
    }


    @Override
    public float cost() {
        return obj.cost() + super.getPrice() ;
    }


    public String getDes(){
        return "des  " + getPrice() + "&& " + obj.getDes();
    }
}
