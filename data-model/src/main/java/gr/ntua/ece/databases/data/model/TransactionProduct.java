package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class TransactionProduct {
    private Long barcode;
    private String productName;
    private String brandName;
    private int pieces;

    public TransactionProduct(Long barcode, int pieces, String productName) {
        this.barcode = barcode;
        this.pieces = pieces;
        this.productName = productName;
    }

    public TransactionProduct() {
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getProductName() {
        return productName;
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