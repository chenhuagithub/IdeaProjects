package com.atguigu.logindemo.service;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;


//@Service
//@SuppressWarnings({"{rawtypes}", "{unchecked}"})
public class RedisSessionDao2 extends AbstractSessionDAO {

    // session的超时时间
    private long expireTime = 120000;

    @Autowired
    private RedisTemplate redisTemplate;

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }


    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisSessionDao2(){
        super();
    }


    public RedisSessionDao2(long expireTime, RedisTemplate redisTemplate){
        this.expireTime = expireTime;
        this.redisTemplate = redisTemplate;
    }

    @Override // 加入session
    protected Serializable doCreate(Session session) {
        System.out.println("================doCreate============");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);

        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
        return sessionId;
    }




    @Override  // 读取session
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("==============doReadSession===============");
        if(sessionId == null){
            return null;
        }
        return (Session) redisTemplate.opsForValue().get(sessionId);
    }


    @Override // 更新session
    public void update(Session session) throws UnknownSessionException {
        System.out.println("==============update=====================");
        if(session ==null || session.getId() == null){
            return;
        }
        session.setTimeout(expireTime);
        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override // 删除session
    public void delete(Session session) {
        System.out.println("===================delete===================");
        if(session == null){
            return;
        }
        redisTemplate.opsForValue().getOperations().delete(session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        System.out.println("=======================getActiveSessions====================");

        return redisTemplate.keys("*");
    }
}
