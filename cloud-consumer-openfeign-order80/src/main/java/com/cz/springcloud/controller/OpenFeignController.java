package com.cz.springcloud.controller;


import com.cz.springcloud.bean.JsonResult;
import com.cz.springcloud.service.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OpenFeignController {


    @Resource
    private OpenFeignService openFeignService;



    @GetMapping("/get")
    JsonResult get(@RequestParam(value = "id") Integer id){
        return openFeignService.get(id);
    }



}
