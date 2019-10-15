package com.atguigu.SingletonType;

public class 懒汉式 {
    public static void main(String[] args) {

//        Singleton2 instance = Singleton2.getInstance();
//        System.out.println(instance.hashCode());
//        Singleton2 instance1 = Singleton2.getInstance();
//        System.out.println(instance1.hashCode());
//        System.out.println(instance == instance1);

        Singleton4 instance = Singleton4.INSTANCE;
        Singleton4 instance1 = Singleton4.INSTANCE;
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

    }

}


class Singleton2{
    // 1. 创建私有构造器
    private Singleton2(){

    }


    // 定义私有静态变量
    private static volatile Singleton2 instance;

    // 定义一个静态内部类
    private static class GetInstance{
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    // 定义一个共有静态方法, 供外部创建实例
    // 加入同步处理代码 synchronized, 解决线程安全问题
    public static Singleton2 getInstance(){
        return GetInstance.INSTANCE;
    }

}

class Singleton3{

    private Singleton3(){

    }

    private static class GetInstance{
        private static final Singleton3 INSTANCE = new Singleton3();
    }


}

class Singleton5{

}

enum Singleton4{
    INSTANCE;

    public void sayOk(){
        System.out.println("ok~~");
    }
}