package com.cz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer  //Eureka的服务端
public class EurekaServerApplication7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7003.class, args);
    }


/*	@Override
	//extends SpringBootServletInitializer
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SadsApplication.class);
	}*/

}
