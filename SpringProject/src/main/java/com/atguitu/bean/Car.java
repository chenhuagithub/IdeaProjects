package com.atguitu.bean;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Car {

    private String carName;
    private String price;
    private String color;


    public Car(){
        System.out.println("car被创建了.....");
    }

    public Car(String carName, String price, String color) {
        this.carName = carName;
        this.price = price;
        this.color = color;
    }


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
