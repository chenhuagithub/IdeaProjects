package com.company;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {

        // 源码阶段

        Class<?> person1 = Class.forName("com.company.Person");
        System.out.println(person1);
        // 获取所有public修饰的成员变量
        Field[] fields = person1.getFields();
        for(Field field: fields){
            System.out.println(field);
        }

        // 获取单个成员变量
        Field hobby = person1.getField("hobby");
        System.out.println(hobby);
        Person per = new Person();
        Object value = hobby.get(per);
        System.out.println(value);
        hobby.set(per,"张三");
        System.out.println(per);

        System.out.println("-------------------------------------");
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        System.out.println("------------------------------------");

        Person p = new Person();
        Class<? extends Person> aClass1 = p.getClass();
        System.out.println(aClass1);

//        System.out.println(aClass == personClass);



    }
}
