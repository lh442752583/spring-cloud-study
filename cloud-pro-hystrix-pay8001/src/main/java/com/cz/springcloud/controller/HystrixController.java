package com.cz.springcloud.controller;


import com.cz.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixController {

    /** 
    * @Description: hystrix一般用在客户端做降级处理，所以在这个服务端只引入了一个hystrix的包并没有做hystrix的实际运用。
     *              为了呼应客户端而建立。
    * @Param:  
    * @return:  
    * @Author: Li
    * @Date: 2020/6/30 
    **/ 



    @Resource
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = hystrixService.paymentInfo_OK(id);
        return result;
    }
    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = hystrixService.paymentInfo_TimeOut(id);
        return result;
    }





    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = hystrixService.paymentCircuitBreaker(id);
        return result;
    }





}
