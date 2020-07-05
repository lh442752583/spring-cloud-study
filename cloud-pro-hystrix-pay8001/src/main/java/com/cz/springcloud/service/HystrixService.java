package com.cz.springcloud.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {



    //成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }






    //失败
    /**
    * @Description:   服务端自己做降级处理，给个兜底的返回   兜底的返回方法是paymentInfo_TimeOutHandler
     *                fallbackMethod参数为兜底调用哪个方法
     *
     *                commandProperties为红线设置，比如我设置这个方法3秒后就触发降级
     *                接口里面是5秒的返回，所以必然会触发红线走兜底的方法
     *
     *
     *                如果是这个接口本来就异常了，也还是会走兜底的方法！
    * @Param:
    * @return:
    * @Author: Li
    * @Date: 2020/7/1
    **/
    //为什么要配置这些参数，这些参数是源码看到的，按下2次shift后输入HystrixCommandProperties查看里面的默认配置属性。
    //或者查看文档里面的ALL配置查看
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        //制造异常
        //int a = 10/0;
        int timeNumber = 3;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }

    //我是上面兜底的方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是服务端兜底的方法";
    }








    //-----------------下面是服务熔断
    //为什么要配置这些参数，这些参数是源码看到的，按下2次shift后输入HystrixCommandProperties查看里面的默认配置属性。
    //或者查看文档里面的ALL配置查看
    @HystrixCommand(fallbackMethod = "circuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
            //这边设置的意思是开启断路器，然后在10秒中的请求时间范围内10次请求的失败率在60%的时候会触发跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String circuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }



}
