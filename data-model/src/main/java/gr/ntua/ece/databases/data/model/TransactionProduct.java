package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class TransactionProduct {
    private Long productId;
    private int pieces;
    private String productName;

    public TransactionProduct(Long productId, int pieces, String productName) {
        this.productId = productId;
        this.pieces = pieces;
        this.productName = productName;
    }

    public TransactionProduct() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

}