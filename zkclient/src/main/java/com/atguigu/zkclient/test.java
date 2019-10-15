package com.atguigu.zkclient;

public class test {
    public static void main(String[] args) {

        String array = "陈话";
        byte[] bytes = array.getBytes();
        System.out.println(bytes);
        for(byte b : bytes){
            System.out.println(b);
        }


    }
}
