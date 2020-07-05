package com.cz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient  //Eureka的客户端
//开启openfeign的注解支持
@EnableFeignClients
@EnableHystrix //开启hystrix的注解支持，客户端的时候用(这个注解和服务端的注解不一样，需要注意)
public class ConsumerOrderOpenFeignHystrixApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderOpenFeignHystrixApplication80.class, args);
    }




}
