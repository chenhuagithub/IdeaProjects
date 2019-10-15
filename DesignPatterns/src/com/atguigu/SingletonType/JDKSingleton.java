package com.atguigu.SingletonType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDKSingleton {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        try {
            Process exec = runtime.exec("python3 /home/chenhua/IdeaProjects/DesignPatterns/src/com/atguigu/python/hello.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            System.out.println(in);
            String line = null;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
            in.close();
            exec.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
