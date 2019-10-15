package com.atguigu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        String result = "";

        try {
            Process process = Runtime.getRuntime().exec("python3 /home/chenhua/IdeaProjects/springcloudproject/demo/src/main/java/com/atguigu/demo/configTest/python/hello.py");
//            process.waitFor();
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            result = input.readLine();
            input.close();
            ir.close();
//            process.waitFor();
        } catch (IOException e) {
            System.out.println("出错了");

//            logger.error("调用python脚本并读取结果时出错：" + e.getMessage());
        }
        System.out.println(result);
//        return result;
    }

}
