package com.cz.springcloud.controller;


import com.cz.springcloud.bean.JsonResult;
import com.cz.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Resource
    PayService payService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/add")
    public JsonResult add(@RequestParam(value = "ls") String ls){
        return new JsonResult(200, "true" + serverPort, payService.add(ls));
    }




    @GetMapping("/get")
    public JsonResult get(@RequestParam(value = "id") Integer id){
        return new JsonResult(200, "true"+ serverPort, payService.get(id));
    }





}
