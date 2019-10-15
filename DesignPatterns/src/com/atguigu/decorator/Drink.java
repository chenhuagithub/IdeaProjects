package com.atguigu.decorator;

public abstract class Drink {

    // 描述
    private String des;
    // 价格
    private float price;

    public Drink() {
    }

    public Drink(float price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "description='" + des + '\'' +
                ", price=" + price +
                '}';
    }


    public abstract float cost();

}
