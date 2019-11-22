package com.zhangzhipeng.zk3.dao;

import com.zhangzhipeng.zk3.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer>, JpaSpecificationExecutor {

    @Query(value = "select * from t_city where pid = ?",nativeQuery = true)
    List<City> findAllById(Integer pid);

}
