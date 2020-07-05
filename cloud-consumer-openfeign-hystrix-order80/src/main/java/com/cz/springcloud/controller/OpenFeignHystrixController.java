package com.cz.springcloud.controller;


import com.cz.springcloud.service.FeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
//全局的降级方法配置（比较针对客户端的controller的层面的自己降级）
//注意全局降级需要每个方法上面加上@HystrixCommand注解，写了@HystrixCommand注解的出了异常都会走全局的降级方法
//如果@HystrixCommand里面有自定义专属的方法的话则会走自定义的方法。
//@DefaultProperties(defaultFallback = "globalFallBackMethod")


//下面是可以最终使用的方式！！！！(针对的是服务端的降级)
//hystrix的最终版写法是只需要在service接口的FeignClient注解里面加个fallback参数定义一个类，然后让这个类实现当前接口
//然后定义每个方法的降级处理逻辑即可，这样解耦也优雅
public class OpenFeignHystrixController {


    @Resource
    private FeignHystrixService openFeignService;



    @GetMapping("/consumer/hystrix/ok/{id}")
    //@HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return openFeignService.paymentInfo_OK(id);
    }



    @GetMapping("/consumer/hystrix/timeout/{id}")
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return openFeignService.paymentInfo_TimeOut(id);
    }



    @GetMapping("/test/consumer/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })*/
    public String paymentInfo_TimeOut2(Integer id){
        //制造异常
        int a = 10/0;
        int timeNumber = 3;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return openFeignService.paymentInfo_TimeOut(id);
    }

    //我是上面兜底的方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是客户端兜底的方法";
    }




    //下面这个是全局fallback方法（全局兜底方法）
    public String globalFallBackMethod(){
        return "这是客户端全局的异常方法";
    }





}
