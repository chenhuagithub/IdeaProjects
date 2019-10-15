package com.atguigu;

import com.atguigu.dao.BloggerMapper;
import com.atguigu.utils.VerificationCode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;


public class BloggerTest {


    @Autowired
    BloggerMapper bloggerMapper;

    @Test
    public void test01(){
        System.out.println(bloggerMapper);
    }

    @Test
    public void test(){

        VerificationCode verificationCode = new VerificationCode();
        verificationCode.SingleSend("13267869217", "123456");

    }

    @Test
    public void test02(HttpSession httpSession){
        System.out.println(httpSession.getAttribute("13267869217"));
    }


}
