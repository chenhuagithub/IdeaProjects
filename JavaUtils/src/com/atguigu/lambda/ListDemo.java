package com.atguigu.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenhua
 */
public class ListDemo {
    public static void main(String[] args) {

        mapTest();
        mapReduceTest();
        filterTest();
    }

    /**
     *
     * map的使用
     * 对象转换
     */
    public static void mapTest(){
        System.out.println("map的使用");
        List<Integer> cost = Arrays.asList(10, 20, 30);
        cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));
        List<String> str = Arrays.asList("aaa", "bbb", "ccc");
        str.stream().map(y -> new StringBuffer(y).append("chenhua").toString()).forEach(y -> System.out.println(y));
    }

    /**
     * reduce的使用
     * reduce将所有值合并为一个
     */
    public static void mapReduceTest(){
        List<Integer> cost = Arrays.asList(10, 20, 30);
        Double res = cost.stream().map(x -> x * 0.05).reduce((sum, x) -> sum + x).get();
        System.out.println(res);
        List<String> str = Arrays.asList("aaa", "bbb", "ccc");
        String s = str.stream().reduce((result, y) -> new StringBuffer(result).append(y).toString()).get();
        System.out.println(s);
    }


    public static void filterTest(){
        System.out.println("filter的使用");
        List<Integer> cost = Arrays.asList(10, 20, 30);
        List<Integer> collect = cost.stream().filter(x -> x >= 20).collect(Collectors.toList());
        System.out.println(collect);
        collect.forEach(x -> System.out.println(x));
        List<String> str = Arrays.asList("chaaa", "chbbb", "huaaa", "hubbb");
        str.stream().filter(x -> x.startsWith("ch")).forEach(x -> System.out.println(x));
    }




}
