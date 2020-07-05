package com.cz.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@MapperScan(basePackages = "com.pay.dao")
@EnableEurekaClient  //Eureka的客户端
public class PayApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication8002.class, args);
    }


/*	@Override
	//extends SpringBootServletInitializer
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SadsApplication.class);
	}*/

}
