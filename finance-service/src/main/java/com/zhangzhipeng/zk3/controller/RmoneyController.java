package com.zhangzhipeng.zk3.controller;

import com.zhangzhipeng.zk3.entity.Contract;
import com.zhangzhipeng.zk3.entity.Rmoney;
import com.zhangzhipeng.zk3.service.RmoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
public class RmoneyController {

    @Autowired
    RmoneyService service;

    @Value("${server.port}")
    String port;

    @RequestMapping("list")
    public Page<Rmoney> query(@RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "rows",defaultValue = "3") Integer rows,
                              Integer cid, String types, String rname, String rbz,
                              String dt1, String  dt2, BigDecimal rp1, BigDecimal rp2){
        System.out.println("负载均衡："+port);
        return service.query(page,rows,cid,types,rname,rbz,dt1,dt2,rp1,rp2);
    }

    @RequestMapping("add")
    public Rmoney add(@RequestBody Rmoney rmoney){
        return service.add(rmoney);
    }

    @RequestMapping("update")
    public Rmoney update(@RequestBody Rmoney rmoney){
        return service.update(rmoney);
    }

    @RequestMapping("del")
    public boolean delete(Integer id){
        return service.delete(id);
    }

    @RequestMapping("dels")
    public boolean deletes(Integer[] ids){
        return service.deletes(ids);
    }

    @RequestMapping("lists")
    public List<Contract> li(){
        return service.list();
    }

    @RequestMapping("selectById")
    public Contract se(Integer id){
        return service.selectById(id);
    }
}
