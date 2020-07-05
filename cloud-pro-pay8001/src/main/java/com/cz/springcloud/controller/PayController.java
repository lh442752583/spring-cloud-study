package com.cz.springcloud.controller;


import com.cz.springcloud.bean.JsonResult;
import com.cz.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Resource
    PayService payService;

    @Resource
    private DiscoveryClient discoveryClient;    //服务发现，向eureka提供服务的信息



    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/add")
    public JsonResult add(@RequestParam(value = "ls") String ls){
        return new JsonResult(200, "true" + serverPort, payService.add(ls));
        //return new JsonResult(200, "true" + serverPort);
    }




    @GetMapping("/get")
    public JsonResult get(@RequestParam(value = "id") Integer id){
        return new JsonResult(200, "true"+ serverPort, payService.get(id));
        //return new JsonResult(200, "true"+ serverPort);
    }




    /** 
    * @Description: 对外展示eureka的注册信息和某个具体的服务名称里面对应的服务详情接口
    * @Param:
    * @return:  
    * @Author: Li
    * @Date: 2020/6/26 
    **/ 
    @GetMapping(value = "/pay/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            //log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAY-SERVICE");
        for (ServiceInstance instance : instances) {
            //log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }






}
