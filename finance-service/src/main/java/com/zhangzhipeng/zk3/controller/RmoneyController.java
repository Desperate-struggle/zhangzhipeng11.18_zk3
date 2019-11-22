package com.zhangzhipeng.zk3.controller;

import com.zhangzhipeng.zk3.entity.City;
import com.zhangzhipeng.zk3.entity.Contract;
import com.zhangzhipeng.zk3.entity.Rmoney;
import com.zhangzhipeng.zk3.service.RmoneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@Api(tags = "增删改查")
public class RmoneyController {

    @Autowired
    RmoneyService service;

    @Value("${server.port}")
    String port;

    @Value("${file.path}")
    String fileImg;

    @Value("${file.fileDomain}")
    String fileDomain;

    @RequestMapping("fileUp")
    public Map<String ,Object> fi(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("res",true);

        String filePath = UUID.randomUUID()+".jpg";
        File file1 = new File(fileImg+filePath);
        file.transferTo(file1);

        map.put("pic",fileDomain+filePath);

        return map;
    }

    @ApiOperation(value = "分页+条件查询")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "page",value = "页码",required = true,paramType = "query",dataType = "Integer"),
            @ApiImplicitParam(name = "rows",value = "每页条数",required = true,paramType = "query",dataType = "Integer")}
    )
    @RequestMapping("list")
    public Page<Rmoney> query(@RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "rows",defaultValue = "3") Integer rows,
                              Integer cid, String types, String rname, String rbz,
                              String dt1, String  dt2, BigDecimal rp1, BigDecimal rp2){
        System.out.println("负载均衡："+port);
        return service.query(page,rows,cid,types,rname,rbz,dt1,dt2,rp1,rp2);
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Rmoney add(@RequestBody Rmoney rmoney){
        return service.add(rmoney);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Rmoney update(@RequestBody Rmoney rmoney){
        return service.update(rmoney);
    }

    @RequestMapping(value = "del",method = RequestMethod.POST)
    public boolean delete(Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "dels",method = RequestMethod.POST)
    public boolean deletes(Integer[] ids){
        return service.deletes(ids);
    }

    @RequestMapping(value = "lists",method = RequestMethod.POST)
    public List<Contract> li(){
        return service.list();
    }

    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    public Contract se(Integer id){
        return service.selectById(id);
    }

    @RequestMapping(value = "selectByPid",method = RequestMethod.POST)
    public List<City> sp(Integer pid){
        return service.findAllById(pid);
    }

    @RequestMapping(value = "selectUpdate",method = RequestMethod.POST)
    public Rmoney selectB(Integer id){
        return service.selectUpdate(id);
    }
}
