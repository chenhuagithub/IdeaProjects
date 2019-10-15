package com.atguigu.controller;

import com.atguigu.bean.Person;
import com.atguigu.service.PersonService;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Controller
public class PersonController {


    @Autowired
    PersonService personService;

    /**
     *
     *   @Valid: 告诉springmvc这个javaBean需要校验
     *
     *   BindingResult result: 保存校验结果
     *
     */
    @RequestMapping("/addPerson")
    public String addPerson(@Valid Person person, BindingResult result){
        // 获取是否有校验错误
        System.out.println(person);
        System.out.println(result);
        boolean hasErrors = result.hasErrors();
        if(hasErrors){
            System.out.println("有校验错误");
            return "redirect:/gotoAddPerson";
        }else {
            personService.addPerson(person);
            return "redirect:/showPersonInfo";
        }

    }


    @RequestMapping("/showPersonInfo")
    public String showPersonInfo(Model model){
        List<Person> allPerson = personService.findAllPerson();
        System.out.println(allPerson);
        model.addAttribute("allPerson", allPerson);
        return "personInfo";
    }


    /**
     *
     *  @ResponseBody:
     *      将返回的数据放在响应体中;
     *      如果是对象, jackson包自动将对象转为json格式
     */

    @ResponseBody
    @RequestMapping("/retujson")
    public Collection<Person> retujson(){
        List<Person> allPerson = personService.findAllPerson();
        System.out.println(allPerson);
        return allPerson;
    }


    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody Person person){
        System.out.println(person);
        return "success";
    }

    /**
     * HttpEntity<String> str: 拿到请求头, 比@RequestHeader更强
     *
     */

    @RequestMapping("/testHttpEntity")
    public String testHttpEntity(HttpEntity<String> str){
        System.out.println(str);

        return "success";
    }

    /**
     *
     * @ResponseBody: 把返回的数据放在响应体中
     */

    @ResponseBody
    @RequestMapping("/testResponseBody")
    public String testResponseBody(){
        return "success";
    }


    /**
     *  文件上传
     *
     *
     *
     */

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username", required = false) String username, @RequestParam("file") MultipartFile file){
        System.out.println("文件参数的名字--->"+file.getName());
        System.out.println("图片的名字--->"+file.getOriginalFilename());


        //文件保存
        try {
            file.transferTo(new File("/home/chenhua/文档/upload/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }



    @ResponseBody
    @RequestMapping("/uploadmore")
    public String uploadmore(@RequestParam(value = "username", required = false) String username, @RequestParam("file") MultipartFile file[]){

        //遍历文件
        for(MultipartFile multipartFile : file){
            if(!multipartFile.isEmpty()){
                System.out.println("文件参数名--->"+multipartFile.getContentType());
                System.out.println("文件名--->"+multipartFile.getOriginalFilename());
                //文件保存
                try {
                    multipartFile.transferTo(new File("/home/chenhua/文档/upload/"+multipartFile.getOriginalFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "success";
    }


    /**
     *  1. 得到要下载的文件的流
     *  2. 找到要下载的文件的真实路径
     *  3.
     */

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam(value = "filename", required = false) String filename ,HttpServletRequest request) throws IOException {


        // 得到要下载的文件的流
        String location = "";

        // 找到要下载的文件的真实路径
        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("/img/"+filename);
        FileInputStream fileInputStream = new FileInputStream(realPath);

        byte[] tmp = new byte[fileInputStream.available()];
        fileInputStream.read(tmp);
        fileInputStream.close();

        // 将要下载的文件流返回
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置响应头, 即下载文件时候文件的名字
        httpHeaders.set("Content-Disposition", "attachment;filename="+filename);
        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }


}
