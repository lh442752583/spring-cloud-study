package com.cz.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class FeignHystrixFallBackService implements FeignHystrixService{


    @Override
    public String paymentInfo_OK(Integer id) {
        return "解耦后的ok方法的兜底";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "解耦后的time_out方法的兜底";
    }
}
