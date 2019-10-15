package com.atguigu.factory;


import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;


public class FilterChaindefinitionMapBuilder {
//!--                /login.jsp = anon-->
//<!--                /hello = anon-->
//<!--                /logout = logout-->
//<!--                /user.jsp = roles[user]-->
//<!--                /admin.jsp = roles[admin]-->
//<!--&lt;!&ndash;                /user.jsp = authc&ndash;&gt;-->
    public LinkedHashMap<String, String> buildFilterDefinitionMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login.jsp", "anon");
        map.put("/hello", "anon");
        map.put("/logout", "logout");
        map.put("/user.jsp", "roles[user]");
        map.put("/admin.jsp", "roles[admin]");
        map.put("/**", "authc");
        return map;
    }

}
