package com.cz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/** 
* @Description: 因为自定义Ribbon的负载均衡的算法的时候不能将自己定义的类放入@ComponentScan的包及子包下， 
* @Param:       因为下面的ConsumerOrderApplication的这个启动类里面有个注解@SpringBootApplication里面包含了
* @return:       @ComponentScan注解，继而需要在springcloud这个包外面新建一个包来配置Ribbon的自定义负载算法才能生效
* @Author: Li
* @Date: 2020/6/27 
**/ 
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
