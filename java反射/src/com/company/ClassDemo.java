package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<Person> personClass = Person.class;
        // 获取类构造器
        Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class, String.class, String.class);

        //实例化对象
        Person person = constructor.newInstance("张三", 56, "111111@qq.com", "打篮球");

        System.out.println("输出Person实例结果是-->"+person);

        // 获取Person类的成员方法
        Method[] methods = personClass.getMethods();
        System.out.print("Person类的成员方法有:");
        for(Method m: methods){
            System.out.print(m+" ;  ");
        }


    }


}
