package com.cz.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {   //开发时openfeign的调用接口日志输出设置

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL; //表示打印全部日志
    }
}

