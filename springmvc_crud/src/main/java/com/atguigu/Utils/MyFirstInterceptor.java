package com.atguigu.Utils;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstInterceptor implements HandlerInterceptor {

    /**
     *
     *   目标方法运行之前运行
     *
     */

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyFirstInterceptor------preHandle");
        /**
         *   返回ture放行, 返回false不放行
         */

        return true;
    }

    /**
     *
     *  在目标方法运行之后地哦啊用: 目标方法调用之后
     *
     */

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor------postHandle");
    }


    /**
     *
     *  在请求整个页面完成后; 来到模样边页面之后; chain.doFilter()放行; 资源响应之后
     *
     */

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyFirstInterceptor------------afterCompletion");
    }
}
