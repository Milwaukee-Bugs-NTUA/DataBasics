package gr.ntua.ece.databases.data.model;

import java.util.*;

public class CommonProduct {
    private Long barcode;
    private String productName;
    private String brandName;

    public CommonProduct(){
    }

    public CommonProduct(Long barcode, String productName){
        this.barcode = barcode;
        this.productName = productName;
    }

    public Long getBarcode() {
        return barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}