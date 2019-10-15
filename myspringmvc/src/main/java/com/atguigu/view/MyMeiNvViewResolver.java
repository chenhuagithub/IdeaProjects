package com.atguigu.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyMeiNvViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        if(viewName.startsWith("meinv")){
            return  null;
        }else {
            return null;
        }


    }
}
