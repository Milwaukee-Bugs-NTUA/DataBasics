package gr.ntua.ece.databases.data.model;

import java.util.*;

public class Products {
    private long barcode;
    private String name;
    private String brandName;
    private float price;

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
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

    public Products(){

    }

    public Products(long barcode, String name, String brandName, float price) {
        this.barcode = barcode;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
    }
}