package com.atguigu.consumerdemo.controller;


import com.atguigu.consumerdemo.client.UserClient;
import com.atguigu.consumerdemo.bean.Teacher;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "fallba")
public class TeacherController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @GetMapping("/consumer")
//    public Teacher findById(Integer id){
//        // 根据服务id获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
//        // 从实例中获取ip和端口号
//        ServiceInstance serviceInstance = instances.get(0);
//        String HostAndPort = serviceInstance.getHost()+":"+serviceInstance.getPort();
//        // 完整地址
//        String url = "http://"+HostAndPort+"/teacher/findById?id="+id;
//        Teacher teacher = restTemplate.getForObject(url, Teacher.class);
//        return teacher;
//    }
//
//
//
//
//
//    @GetMapping("/consumer2")
////    @HystrixCommand(fallbackMethod = "findByIdFallbackMethod")
////    @HystrixCommand(commandProperties = {
////            // 配置该方法的超时间
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
////    })
////    @HystrixCommand
//    @HystrixCommand(commandProperties = {
//            // 阈值统计次数的参考, 即设置10次为一次统计
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            // 休眠时间窗, 即服务熔断后, 每隔10秒时间检查一次请求是否正常, 如果正常则关闭熔断, 否则熔断处于半开放状态
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            // 错误百分比, 即请求失败数占总请求数的比例
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
//    public String findById2(Integer id) {
//        if(id % 2 == 0){
//            throw new RuntimeException("id是偶数");
//        }
//        String url = "http://user-service/teacher/findById?id="+id;
//        String teacher = restTemplate.getForObject(url, String.class);
//        return teacher;
//    }
//
//
//    public String fallba(){
//        return "服务器繁忙";
//    }
//
//    // 熔断函数, 函数的参数必须和成功的函数一致, 函数名可以随便取
//    public Teacher findByIdFallbackMethod(Integer id){
//        System.out.println("我来了老铁");
//        return null;
//    }


    @Autowired
    UserClient userClient;

    @GetMapping("/consumer3/{id}")
    public Teacher findById3(@PathVariable("id") Integer id){
        System.out.println("id--------------->"+id);
        Teacher teacher = userClient.queryTeacher(id);
        return teacher;
    }

}
