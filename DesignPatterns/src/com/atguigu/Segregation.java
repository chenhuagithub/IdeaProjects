package com.atguigu;

public class Segregation {

    public static void main(String[] args) {
        String str = new String("陈华");
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);

        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder);


    }


}
