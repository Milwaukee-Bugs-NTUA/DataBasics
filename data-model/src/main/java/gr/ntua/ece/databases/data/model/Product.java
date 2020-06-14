package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

public class Product {
    private Long barcode;
    private String name;
    private String brandName;
    private float price;
    private OfferedInStore offeredInStore;
    private Long categoryId;
    private String categoryName;
    private Timestamp startingSaleDatetime;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public OfferedInStore getOfferedInStore() {
        return offeredInStore;
    }

    public void setOfferedInStore(OfferedInStore offeredInStore) {
        this.offeredInStore = offeredInStore;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(){

    }

    public Timestamp getStartingSaleDatetime() {
        return startingSaleDatetime;
    }

    public void setStartingSaleDatetime(Timestamp timestamp) {
        this.startingSaleDatetime = timestamp;
    }
}