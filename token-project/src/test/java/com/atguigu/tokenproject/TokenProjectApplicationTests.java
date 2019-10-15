package com.atguigu.tokenproject;

import com.atguigu.tokenproject.utils.JwtUtil;
import io.jsonwebtoken.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenProjectApplicationTests {

    @Autowired
    private JwtUtil jwtUtil;


    @Test
    public void test2(){
        String jwt = jwtUtil.createJWT("666", "chenhua", "admin");
        System.out.println(jwt);
    }

    @Test
    public void test3(){
        Claims claims = jwtUtil.pareJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJjaGVuaHVhIiwiaWF0IjoxNTY5MjA2NzUwLCJyb2xlIjoiYWRtaW4iLCJleHAiOjE1NjkyMTAzNTB9.MVh11MoQ6ygqsRcu60dRC7J-oCd3ydR3t_c_uUR9F5g");
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getExpiration());

    }

    /**
     * 生成令牌token
     */
    @Test
    public void contextLoads() {

        JwtBuilder jwtBuilder = Jwts.builder()
                // 登录id号码
                .setId("666")
                // 登录用户
                .setSubject("小马")
                // 登录时间
                .setIssuedAt(new Date())
                // 头部
                .signWith(SignatureAlgorithm.HS256, "itcast")
                // 设置过期时间
                .setExpiration(new Date(new Date().getTime() + 60 * 1000))
                // 设置自己的键值对
                .claim("role", "admin");
        // 生成字符串
        String compact = jwtBuilder.compact();

        System.out.println(compact);


    }

    /**
     * 解析令牌
     */
    @Test
    public void jiexiToken(){
        Claims claims = Jwts.parser()
                .setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NjkyMDQ2ODQsImV4cCI6MTU2OTIwNDc0NCwicm9sZSI6ImFkbWluIn0.PzWqDn0-RE2tf4PP7ONU93qdP2rtUhofmaR7PwGpTLQ")
                .getBody();
        System.out.println("用户id:"+claims.getId());
        System.out.println("用户名:"+claims.getSubject());
        System.out.println("登录时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("角色:"+claims.get("role"));
    }


}
