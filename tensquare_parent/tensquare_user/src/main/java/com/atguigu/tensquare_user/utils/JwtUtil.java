package com.atguigu.tensquare_user.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "jwt.config")
public class JwtUtil {

    // 盐值
    private String key;
    // 过期时间
    private long ttl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }


    /**
     * 生成令牌token
     * @param id 盐值
     * @param subject 用户名
     * @param roles 角色
     * @return
     */
    public String createJWT(String id, String subject, String roles){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder jwtBuilder = Jwts.builder()
                // 登录id号码
                .setId(id)
                // 登录用户
                .setSubject(subject)
                // 登录时间
                .setIssuedAt(new Date())
                // 头部
                .signWith(SignatureAlgorithm.HS256, this.key)
                // 设置过期时间
//                .setExpiration(new Date(new Date().getTime() + 60 * 1000))
                // 设置自己的键值对
                .claim("roles", roles);

        if(ttl > 0){
            jwtBuilder.setExpiration(new Date(nowMillis + this.ttl));
        }
        // 生成字符串
        String compact = jwtBuilder.compact();


        return compact;
    }

    /**
     * 解析令牌
     * @param jwtStr 令牌字符串
     * @return
     */

    public Claims pareJWT(String jwtStr){
        return Jwts.parser()
                .setSigningKey(this.key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
}
