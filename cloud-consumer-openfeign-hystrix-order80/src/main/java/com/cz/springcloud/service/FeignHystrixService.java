package com.cz.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component  //让spring能够扫描到
@FeignClient(value = "CLOUD-HYSTRIX-PAY-SERVICE", fallback = FeignHystrixFallBackService.class)  //通过feign来进行服务调用，通过服务名称
public interface FeignHystrixService {


    /** 
    * @Description: 直接复制的提供服务的controller的方法
    * @Param:       注意：openfeign的调用服务接口时间默认是1秒调用时间，超时会报错
     *              解决：在application.yml配置文件中进行配置
    * @return:  
    * @Author: Li
    * @Date: 2020/6/28 
    **/
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);



    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);


}
