package com.cz.springcloud.controller;


import com.cz.springcloud.bean.JsonResult;
import com.cz.springcloud.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAY-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/add")
    public JsonResult<Payment> add(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/pay/add?ls=" + payment.getLs(), payment, JsonResult.class);
    }



    @GetMapping("/consumer/get/{id}")
    public JsonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get?id="+id, JsonResult.class);
    }




}
