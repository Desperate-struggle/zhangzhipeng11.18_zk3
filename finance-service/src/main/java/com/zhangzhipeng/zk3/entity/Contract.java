package com.zhangzhipeng.zk3.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String cnumber;//合同编号

    String clnumber;//客户编号


    BigDecimal cprice;//合同金额

    String cbz;//备注

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", cnumber='" + cnumber + '\'' +
                ", clnumber='" + clnumber + '\'' +
                ", cprice=" + cprice +
                ", cbz='" + cbz + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getClnumber() {
        return clnumber;
    }

    public void setClnumber(String clnumber) {
        this.clnumber = clnumber;
    }

    public BigDecimal getCprice() {
        return cprice;
    }

    public void setCprice(BigDecimal cprice) {
        this.cprice = cprice;
    }

    public String getCbz() {
        return cbz;
    }

    public void setCbz(String cbz) {
        this.cbz = cbz;
    }
}
