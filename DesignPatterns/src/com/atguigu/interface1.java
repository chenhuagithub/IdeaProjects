package com.atguigu;

public interface interface1 {

    public void operation1();
    public void operation2();
    public void operation3();
    public void operation4();
    public void operation5();

}


class B implements interface1{

    @Override
    public void operation1() {
        System.out.println("B实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B实现了operation5");
    }
}

class D implements interface1{

    @Override
    public void operation1() {
        System.out.println("D实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D实现了operation5");
    }
}



class A{
    public void depend1(interface1 i){
        i.operation1();
    }
}

class demo{
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
    }
}