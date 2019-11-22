package com.zhangzhipeng.zk3.service;

import com.zhangzhipeng.zk3.dao.ContractDao;
import com.zhangzhipeng.zk3.dao.RmoneyDao;
import com.zhangzhipeng.zk3.entity.Contract;
import com.zhangzhipeng.zk3.entity.Rmoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RmoneyServiceImpl implements RmoneyService{

    @Autowired
    RmoneyDao dao;

    @Autowired
    ContractDao contractDao;


    @Override
    public Page<Rmoney> query(Integer page, Integer rows, Integer cid, String types, String rname, String rbz, String dt1, String dt2, BigDecimal rp1, BigDecimal rp2) {

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (!StringUtils.isEmpty(cid)){
                    Predicate like = criteriaBuilder.equal(root.get("cid"),cid);
                    list.add(like);
                }
                if (!StringUtils.isEmpty(types)){
                    if (!StringUtils.isEmpty(rname)){
                        Predicate name1 = criteriaBuilder.like(root.get("rname"), '%' + rname + '%');
                        list.add(name1);
                    }
                    if (!StringUtils.isEmpty(rbz)){
                        Predicate bz1 = criteriaBuilder.like(root.get("rbz"), '%' + rbz + '%');
                        list.add(bz1);
                    }
                }
                if (!StringUtils.isEmpty(dt1)&&!StringUtils.isEmpty(dt2)){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date date1 = simpleDateFormat.parse(dt1);
                        Date date2 = simpleDateFormat.parse(dt2);
                        Predicate rdt = criteriaBuilder.between(root.get("rdt"), date1, date2);
                        list.add(rdt);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (!StringUtils.isEmpty(rp1)&&!StringUtils.isEmpty(rp2)){
                    Predicate rspare = criteriaBuilder.between(root.get("rspare"), rp1, rp2);
                    list.add(rspare);
                }

                Predicate[] predicates = new Predicate[list.size()];
                Predicate[] predicates1 = list.toArray(predicates);
                Predicate and = criteriaBuilder.and(predicates1);
                return and;
            }
        };
        PageRequest pageRequest = PageRequest.of(page - 1, rows);
        return dao.findAll(specification,pageRequest);
    }

    @Override
    public List<Contract> list() {
        return contractDao.findAll();
    }

    @Override
    public Rmoney add(Rmoney rmoney) {
        return dao.save(rmoney);
    }

    @Override
    public Rmoney update(Rmoney rmoney) {
        return dao.save(rmoney);
    }

    @Override
    public boolean delete(Integer id) {
        dao.deleteById(id);
        return true;
    }

    @Override
    public boolean deletes(Integer[] ids) {
        for (Integer i:ids){
            dao.deleteById(i);
        }
        return true;
    }

    @Override
    public Contract selectById(Integer id) {
        return contractDao.findById(id).get();
    }
}
