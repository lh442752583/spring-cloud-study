package com.cz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient  //Eureka的客户端
//开启openfeign的注解支持
@EnableFeignClients
public class ConsumerOrderOpenFeignApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderOpenFeignApplication80.class, args);
    }




}
