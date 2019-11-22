package com.zhangzhipeng.zk3.service;

import com.zhangzhipeng.zk3.entity.City;
import com.zhangzhipeng.zk3.entity.Contract;
import com.zhangzhipeng.zk3.entity.Rmoney;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface RmoneyService {

    Page<Rmoney> query(Integer page, Integer rows, Integer cid, String types, String rname,
                       String rbz, String dt1, String  dt2, BigDecimal rp1,BigDecimal rp2);

    List<Contract> list();

    Rmoney add(Rmoney rmoney);

    Rmoney update(Rmoney rmoney);

    boolean delete(Integer id);

    boolean deletes(Integer[] ids);

    Contract selectById(Integer id);

    List<City> findAllById(Integer pid);

}
