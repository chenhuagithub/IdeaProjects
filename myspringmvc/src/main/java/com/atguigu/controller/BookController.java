package com.atguigu.controller;


import com.atguigu.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mybook")
public class BookController {

    /**
     *  请求乱码:
     *      GET请求: 改tomcat中的server.xml, 在8080端口出添加UTIEncoding="UTF-8"
     *      POST请求:
     *          1. 在第一次获取请求参数之前是设置request.setCharacterEncoding("utf-8")
     *          2. 在web.xml中配置filter
     *
     *  相应乱码
     *      request.setContentType("text/html;charset=utf-8")
     *
     *
     */

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(Book book){
        System.out.println("添加图书");
        System.out.println("我要保存的图书--->"+book);
        System.out.println("地址--->"+book.getAddress());
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id")Integer id){
        System.out.println("删除"+id+"号图书");
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id")Integer id){
        System.out.println("修改"+id+"号图书");
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String selectBook(@PathVariable("id")Integer id){
        System.out.println("查询"+id+"号图书");
        return "success";
    }

}
