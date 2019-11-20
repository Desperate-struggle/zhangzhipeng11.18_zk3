package com.zhangzhipeng.zk3.controller;

import com.zhangzhipeng.zk3.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignService service;

    @RequestMapping("lll")
    public String ls(){
        return service.lll();
    }
}
