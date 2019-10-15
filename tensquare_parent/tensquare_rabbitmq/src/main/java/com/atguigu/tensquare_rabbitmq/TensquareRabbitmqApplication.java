package com.atguigu.tensquare_rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class TensquareRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareRabbitmqApplication.class, args);
    }


    @Bean
    public Queue directQueue(){
        return new Queue("direct_queue", true);
    }

}
