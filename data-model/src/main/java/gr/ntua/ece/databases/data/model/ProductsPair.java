package gr.ntua.ece.databases.data.model;

import java.util.*;

public class ProductsPair {
    private Long barcode1;
    private Long barcode2;
    private String productName1;
    private String brandName1;
    private String productName2;
    private String brandName2;

    public ProductsPair() {
    }

    public Long getBarcode1() {
        return barcode1;
    }
    
    public void setBarcode1(Long barcode) {
        this.barcode1 = barcode;
    }

    public Long getBarcode2() {
        return barcode2;
    }
    
    public void setBarcode2(Long barcode) {
        this.barcode2 = barcode;
    }

    public String getProductName1() {
        return productName1;
    }

    public String getProductName2() {
        return productName2;
    }

    public void setProductName1(String productName) {
        this.productName1 = productName;
    }

    public void setProductName2(String productName) {
        this.productName2 = productName;
    }

    public String getBrandName1() {
        return brandName1;
    }

    public String getBrandName2() {
        return brandName2;
    }

    public void setBrandName1(String brandName) {
        this.brandName1 = brandName;
    }

    public void setBrandName2(String brandName) {
        this.brandName2 = brandName;
    }
}