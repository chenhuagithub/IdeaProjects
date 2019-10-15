package com.atguitu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeoutException;

//
//@Aspect  //告诉spring这是一个切面类
//@Component
public class LogUtils {

    /**
     * @Before: 在目标方法之前运行;                前置通知
     * @After: 在目标方法结束之后运行;              后置通知
     * @AfterReturning: 在目标方法正常返回之后运行   返回通知
     * @AfterThrowing: 在目标犯法抛出异常之后运行我   异常通知
     * @Aroud: 环绕                               环绕通知
     */


    /**
     *
     *  joinPoint: 封装了当前目标方法的详细信息
     */

    /**
     *  抽取可重用的切入点表达式
     *      1. 随便声明一个没有实现的返回void的空方法
     *      2. 给方法上标注@Pointcut注解
     */
//
//    @Pointcut("execution(public Integer com.atguitu.Imp.MyMathCalculator.*(int, int))")
//    public void common(){}


//    @Around("common()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        //获取参数列表
        Object[] args = pjp.getArgs();
        //获取目标方法名字
        String name = pjp.getSignature().getName();
        Object proceed = null;

        try{
            System.out.println("[环绕前置通知] ["+name+"]方法开始");
            //执行目标函数, 返回函数执行后的结果
            proceed = pjp.proceed(args);
            System.out.println("[环绕返回通知] ["+name+"]方法返回, 返回值为:"+proceed);
        }catch (Exception ex){
            System.out.println("[环绕异常通知] ["+name+"]方法出现异常, 异常信息为:"+ex);
            throw new TimeoutException();
        }finally {
            System.out.println("[环绕方法后置通知] ["+name+"]方法结束");
        }


        return proceed;
    }


//    @Before("execution(public Integer com.atguitu.Imp.MyMathCalculator.*(int, int))")
//    @Before("common()")
    public static void logStart(JoinPoint joinPoint){
        // 获取目标方法参数列表
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]方法开始执行,用的参数列表是:"+ Arrays.asList(args));
    }

    // returning="": 函数代理函数返回的结果,
//    @AfterReturning(value = "common()",returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]方法正常执行完成, 方法执行后的结果是:"+result);
    }

    // throwing="": 代理函数抛出的异常
//    @AfterThrowing(value = "common()", throwing = "ex")
    public static void logException(JoinPoint joinPoint, Exception ex){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]方法执行出现异常,异常信息是:"+ex);
    }

//    @After("common()")
    public static void logEnd(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]方法最终结束了");
    }





}
