package com.cz.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@MapperScan(basePackages = "com.pay.dao")
@EnableEurekaClient  //Eureka的客户端
@EnableDiscoveryClient //提供对外展示eureka的注册信息和某些服务的详情的支持注解
public class PayApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication8001.class, args);
    }


/*	@Override
	//extends SpringBootServletInitializer
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SadsApplication.class);
	}*/

}
