package com.smartevn.cokhi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="export")
public class ExportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String description;
    private String imagepath;
    private long amount;
    private Date exportedAt;
    private int user;
    private long product;
    
    private long catcon;
    private long tn;
    private long sk1;
    private long sk2;
    private long sk3;
    private long nu;
    private long dan;
    private long no;
    
    public Date getExported_at() {
        return exportedAt;
    }
    public void setExported_at(Date exported_at) {
        this.exportedAt = exported_at;
    }
    
    public Date getExportedAt() {
        return exportedAt;
    }
    public void setExportedAt(Date exportedAt) {
        this.exportedAt = exportedAt;
    }
    public long getCatcon() {
        return catcon;
    }
    public void setCatcon(long catcon) {
        this.catcon = catcon;
    }
    public long getTn() {
        return tn;
    }
    
    public void setTn(long tn) {
        this.tn = tn;
    }
    public long getSk1() {
        return sk1;
    }
    public void setSk1(long sk1) {
        this.sk1 = sk1;
    }
    public long getSk2() {
        return sk2;
    }
    public void setSk2(long sk2) {
        this.sk2 = sk2;
    }
    public long getSk3() {
        return sk3;
    }
    public void setSk3(long sk3) {
        this.sk3 = sk3;
    }
    public long getNu() {
        return nu;
    }
    public void setNu(long nu) {
        this.nu = nu;
    }
    public long getDan() {
        return dan;
    }
    public void setDan(long dan) {
        this.dan = dan;
    }
    public long getNo() {
        return no;
    }
    public void setNo(long no) {
        this.no = no;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImagepath() {
        return imagepath;
    }
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public long getProduct() {
        return product;
    }
    public void setProduct(long product) {
        this.product = product;
    }
}
