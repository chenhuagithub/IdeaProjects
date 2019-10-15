//package com.atguigu.tensquare_zuul.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.apache.http.protocol.RequestContent;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//public class MyZuulFilter extends ZuulFilter {
//    /**
//     * 过滤器的类型
//     * pre: 执行之前过滤
//     * post: 执行之后处理
//     * @return
//     */
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    /**
//     * 多个过滤器的执行顺序, 数字越小, 表示越先执行
//     * @return
//     */
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    /**
//     * 是否开启过滤器
//     * true: 表示开启
//     * false: 表示关闭
//     * @return
//     */
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//
//    /**
//     * 过滤器内执行的操作, return任何object的值都表示继续执行
//     * @return
//     * @throws ZuulException
//     */
//    @Override
//    public Object run() throws ZuulException {
//        System.out.println("经过后台过滤了");
//        // 得到request上下文
//        RequestContext currentContext = RequestContext.getCurrentContext();
//        // 得到request域
//        HttpServletRequest request = currentContext.getRequest();
//        // 得到头信息
//        String header = request.getHeader("Authorization");
//        System.out.println(header);
//        // 判断是否有头信息
//        if(header != null && !header.equals("")){
//            // 把头信息继续往下传
//            System.out.println("我进来了~");
//            currentContext.addZuulRequestHeader("Authorization", header);
//
//        }
//        return null;
//    }
//}
