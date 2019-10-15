package com.atguigu.建造者模式;

// 抽象建造者
public abstract class HouseBuilder {

    protected House house = new House();

    // 建造流程, 抽象的方法

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();


    // 建造房子
    public House buildHouse(){
        return house;
    }


}
