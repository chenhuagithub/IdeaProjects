package com.atguigu.springbootaopproject.service;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.springbootaopproject.bean.AopLog;
import com.atguigu.springbootaopproject.dao.AopLogMapper;
import com.atguigu.springbootaopproject.utils.HttpContextUtils;
import com.atguigu.springbootaopproject.utils.IPUtils;
import lombok.extern.java.Log;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author chenhua
 */

@Service
public class AopLogService {

    @Autowired
    private AopLogMapper aopLogMapper;

    public void saveLog(ProceedingJoinPoint joinPoint, int time) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AopLog aopLog = new AopLog();
        Log sysLog = method.getAnnotation(Log.class);
        if (sysLog != null) {
            aopLog.setOperation(sysLog.toString());
        }
        // 请求方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        // 请求参数名
        Object[] args = joinPoint.getArgs();
        try {
            // 转化为json串
            String parms = JSONObject.toJSONString(args);
        }catch (Exception e) {

        }


        // 获取请求
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置ip地址
        aopLog.setUser_id(33);
        aopLog.setIp(IPUtils.getIpAddr(request));
        aopLog.setUsername("chenhua");
        aopLog.setOperation("aaaa");
        aopLog.setTime(time);
        aopLog.setMethod(methodName);
        aopLog.setParams("add");
        aopLog.setGmt_create(new Date());
        aopLogMapper.insert(aopLog);

    }



}
