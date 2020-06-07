package gr.ntua.ece.databases.data.model;

import java.util.*;

public class ProductsPair {
    private Long barcode1;
    private Long barcode2;
    private String productName1;
    private String productName2;

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
}