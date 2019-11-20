package com.zhangzhipeng.zk3.dao;

import com.zhangzhipeng.zk3.entity.Rmoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RmoneyDao extends JpaRepository<Rmoney,Integer>, JpaSpecificationExecutor {
}
