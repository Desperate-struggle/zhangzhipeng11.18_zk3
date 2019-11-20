package com.zhangzhipeng.zk3.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "finance-service")
public interface FeignService {

    @RequestMapping("list")
    public String lll();

}
