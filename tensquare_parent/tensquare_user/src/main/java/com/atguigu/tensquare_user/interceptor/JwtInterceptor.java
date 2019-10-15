package com.atguigu.tensquare_user.interceptor;

import com.atguigu.tensquare_user.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    /**
     * 请求到达服务器之前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Autowired
    private JwtUtil jwtUtil;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("经过拦截器");
        String header = request.getHeader("Authorization");
        System.out.println("=============");
        System.out.println("头部信息:"+header);
        System.out.println("=============");
        if(header != null && !header.equals("")){
            if(header.startsWith("Bearer")){
                // 得到token
                String token = header.substring(7);
                System.out.println("++++++++++++++++");
                System.out.println("token:"+token);
                System.out.println("+++++++++++++++++");

                try {
                    Claims claims = jwtUtil.pareJWT(token);
                    String roles = (String) claims.get("roles");
                    if(roles.equals("admin")){
                        request.setAttribute("claims_admin", token);
                    }
                    if(roles.equals("user")){
                        request.setAttribute("claims_user", token);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确");
                }



            }


        }
        return true;
    }


}
