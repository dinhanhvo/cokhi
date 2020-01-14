package com.smartevn.cokhi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author vadinh
 *
 *    this.productInsert = {
      "name": this.name,        
      "description": this.description, 
      "imagepath": this.imagepath,   
      "price": this.price,      
      "note": this.note,        
      "from": this.from,        
      "status": this.status,      
      "unit": this.unit,       
      "type": this.type,        
      "currencyId": this.currencyId,
      "imported_at": new Date()
    }

 */
@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="`name`")
    private String name;
    
    @Column(name="`description`")
    private String description;
    
    @Column(name="`imagepath`")
    private String imagepath;
    
    @Column(name="`imported_at`")
    private Date imported_at;
    
    @Column(name="`price`")
    private double price;
    
    @Column(name="`note`")
    private String note;
    
    @Column(name="`from`")
    private String from;
    
    @Column(name="`status`")
    private String status;
    
    @Column(name="`unit`")
    private String unit;
    
    @Column(name="`categoryId`")
    private int categoryId;
    
    @Column(name="`type`")
    private int type;
    
    @Column(name="currencyId")
    private int currencyId;
    
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "images_detail",
//        joinColumns = @JoinColumn(name = "type"),
//        inverseJoinColumns = @JoinColumn(name = "id"))
//    private List<ImagesDetail> imgs = new ArrayList<ImagesDetail>();
    
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
