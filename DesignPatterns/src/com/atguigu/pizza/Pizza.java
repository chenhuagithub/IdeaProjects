package com.atguigu.pizza;

public abstract class Pizza {

    protected String name;

    // 抽象方法, 让不同种类的批萨类进行实现
    public abstract void prepare();

    public void setName(String name){
        this.name = name;
    }
    public void bake(){
        System.out.println(name + " baking;");
    }

    public void cut(){
        System.out.println(name + " cutting;");
    }

    public void box(){
        System.out.println(name + " boxing;");
    }

}
