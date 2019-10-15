package com.atguigu;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class mytest {

    @Test
    public void test01(){
        //加密方式
        String algorithmName="SHA1";

        //加密的字符串
        String source="123456";

        //盐值，用于和密码混合起来用
        ByteSource salt = ByteSource.Util.bytes("admin");

        //加密的次数,可以进行多次的加密操作
        int hashIterations = 1024;

        //通过SimpleHash 来进行加密操作
        SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);

        System.out.println(hash.toString());

    }

    @Test
    public void test02(){

            String hashAlgorithmName = "MD5";
            String credentials = "123456";
            int hashIterations = 1024;
//            ByteSource credentialsSalt = null;
            ByteSource credentialsSalt = ByteSource.Util.bytes("user");
            Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
            System.out.println(obj);

    }




}
