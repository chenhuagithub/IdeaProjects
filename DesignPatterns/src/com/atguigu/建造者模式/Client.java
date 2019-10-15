package com.atguigu.建造者模式;

public class Client {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector(new HighBuilding());
        House house = houseDirector.constructHouse();
    }
}
