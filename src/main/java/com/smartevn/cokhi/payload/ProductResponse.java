package com.smartevn.cokhi.payload;

import java.util.Date;

import javax.persistence.*;

/**
 * 
 * @author vadinh
 *
 */
public class ProductResponse {
    
    private Long id;
    private String name;
    private String description;
    private String imagepath;
    private Date imported_at;
    private double price;
    private String note;
    private String from;
    private String status;
    private String unit;
    private int type;
    private int currencyId;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public Date getImported_at() {
        return imported_at;
    }
    public void setImported_at(Date imported_at) {
        this.imported_at = imported_at;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getCurrencyId() {
        return currencyId;
    }
    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }
    
}
