package com.cz.springcloud;

import com.cz.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient  //Eureka的客户端
//意思是访问这个名字的服务的时候不再使用负载均衡算法进行调用，而是用自己配置的随机访问的方式进行调用
@RibbonClient(name = "CLOUD-PAY-SERVICE",configuration = MySelfRule.class)
public class ConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }


/*	@Override
	//extends SpringBootServletInitializer
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SadsApplication.class);
	}*/

}
