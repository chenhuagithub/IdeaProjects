package com.atguigu.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

@Component
public class MD5Tool {

    /**
     *
     * @param hashAlgorithmName: 加密方式
     * @param credentials: 需要加密的字符串
     * @param credentialsSalt: 盐值
     * @param hashIterations: 加密的次数
     * @return
     */
    public String getMD5Code(String hashAlgorithmName, String credentials, String credentialsSalt, int hashIterations){
        ByteSource salt = ByteSource.Util.bytes(credentialsSalt);
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        return simpleHash.toString();

    }


}
