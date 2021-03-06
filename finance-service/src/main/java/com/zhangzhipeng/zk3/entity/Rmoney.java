package com.zhangzhipeng.zk3.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "t_rmoney")
public class Rmoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "cid",insertable = false,updatable = false)
    Contract contract;

    Integer cid;

    String cnumber;

    String types;//选择搜索

    BigDecimal rspare;//余款

    String rnumber;//回款编号

    Date rdt;//回款日期

    BigDecimal rprice;//回款金额

    String rname;//收款人

    String rbz;//备注

    String pic;//图片

    Integer shengid;
    @Transient
    String shengname;

    Integer shiid;
    @Transient
    String shiname;

    Integer quid;
    @Transient
    String quname;


    @Override
    public String toString() {
        return "Rmoney{" +
                "id=" + id +
                ", contract=" + contract +
                ", cid=" + cid +
                ", cnumber='" + cnumber + '\'' +
                ", types='" + types + '\'' +
                ", rspare=" + rspare +
                ", rnumber='" + rnumber + '\'' +
                ", rdt=" + rdt +
                ", rprice=" + rprice +
                ", rname='" + rname + '\'' +
                ", rbz='" + rbz + '\'' +
                ", pic='" + pic + '\'' +
                ", shengid=" + shengid +
                ", shengname='" + shengname + '\'' +
                ", shiid=" + shiid +
                ", shiname='" + shiname + '\'' +
                ", quid=" + quid +
                ", quname='" + quname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public BigDecimal getRspare() {
        return rspare;
    }

    public void setRspare(BigDecimal rspare) {
        this.rspare = rspare;
    }

    public String getRnumber() {
        return rnumber;
    }

    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
    }

    public Date getRdt() {
        return rdt;
    }

    public void setRdt(Date rdt) {
        this.rdt = rdt;
    }

    public BigDecimal getRprice() {
        return rprice;
    }

    public void setRprice(BigDecimal rprice) {
        this.rprice = rprice;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRbz() {
        return rbz;
    }

    public void setRbz(String rbz) {
        this.rbz = rbz;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getShengid() {
        return shengid;
    }

    public void setShengid(Integer shengid) {
        this.shengid = shengid;
    }

    public String getShengname() {
        return shengname;
    }

    public void setShengname(String shengname) {
        this.shengname = shengname;
    }

    public Integer getShiid() {
        return shiid;
    }

    public void setShiid(Integer shiid) {
        this.shiid = shiid;
    }

    public String getShiname() {
        return shiname;
    }

    public void setShiname(String shiname) {
        this.shiname = shiname;
    }

    public Integer getQuid() {
        return quid;
    }

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    public String getQuname() {
        return quname;
    }

    public void setQuname(String quname) {
        this.quname = quname;
    }
}
