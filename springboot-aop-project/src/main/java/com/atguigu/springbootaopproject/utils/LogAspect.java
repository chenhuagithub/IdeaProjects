package com.atguigu.springbootaopproject.utils;


import com.atguigu.springbootaopproject.service.AopLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @author chenhua
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Autowired
    private AopLogService aopLogService;


    @Pointcut("execution(* com.atguigu.springbootaopproject.controller.*.*(..))")
    public void logPointCut() {

    }

    /**
     * 前置通知
     * @throws Throwable
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("前置通知");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录请求内容
        LOGGER.info("请求地址: " + request.getRequestURL().toString());
        LOGGER.info("请求方法: " + request.getMethod());
        // 获取真实的ip
        LOGGER.info("类方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("类参数: " + Arrays.toString(joinPoint.getArgs()));

    }


    /**
     * 后置通知
     */
    @After("logPointCut()")
    public void doAfter() {
        System.out.println("后置通知");
        LOGGER.info("请求响应成功~");

    }

    /**
     *
     */
    @AfterThrowing("logPointCut()")
    public void doThrow() {
        System.out.println("异常通知");
    }


    /**
     * 后置运行通知
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void doReturn(Object result) throws Throwable{
        System.out.println("AfterReturning~");
        LOGGER.info("返回值: " + result);
    }

    /**
     * 后置最终通知
     */
    @Around("logPointCut()")
    public Object doAroud(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        int time = (int) (System.currentTimeMillis() - startTime);
        LOGGER.info("耗时: " + time);
        aopLogService.saveLog(pjp, time);
        return ob;
    }



}
