package com.zhangzhipeng.zk3.dao;

import com.zhangzhipeng.zk3.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContractDao extends JpaRepository<Contract,Integer>, JpaSpecificationExecutor {
}
