package com.atguigu.linkedlist;

public class test {


    public static void main(String[] args) {

        Person p1 = new Person("张三", 12);
        Person p2;
        p2 = p1;
        System.out.println(p2 == p1);


    }

}


class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}