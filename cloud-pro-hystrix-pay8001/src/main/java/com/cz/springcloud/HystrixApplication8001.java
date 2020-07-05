package com.cz.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient  //Eureka的客户端
@EnableCircuitBreaker  //开启服务端熔断的注解支持
public class HystrixApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication8001.class, args);
    }




    
    
    /** 
    * @Description: 此配置是为了9001的hystrix服务器监控而配置，与服务容器本身无关，springcloud升级后的坑 
    * @Param:       servletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
     *              只要在自己的项目里配置上下面的servlet就可以了
    * @return:
    * @Author: Li
    * @Date: 2020/7/2 
    **/ 
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }





}
