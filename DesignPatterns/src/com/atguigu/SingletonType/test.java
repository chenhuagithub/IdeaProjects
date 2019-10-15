package com.atguigu.SingletonType;

public class test {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        System.out.println(instance.hashCode());
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance == instance1);


    }

}


class Singleton{

    // 1. 构造器私有化
    private Singleton(){

    }


    // 2. 类内部创建对象
    private final static Singleton instance;

    // 在静态代码块中创建单例
    static {
        instance = new Singleton();
    }

    // 3. 向外暴露一个静态的公共方法
    public static Singleton getInstance(){
        return instance;
    }


}



