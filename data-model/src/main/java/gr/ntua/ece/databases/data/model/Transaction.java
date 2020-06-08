package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

enum PaymentMethod {
    cash,
    card,
    any // dummy value for filtering transactions
}

public class Transaction {
    private Timestamp datetime;
    private Long  cardNumber;
    private float totalCost;
    private PaymentMethod paymentMethod;
    private int numberOfProducts;
    private String purchasedFrom;

    public Transaction(){
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public void setPurchasedFrom(String purchasedFrom) {
        this.purchasedFrom = purchasedFrom;
    }

}