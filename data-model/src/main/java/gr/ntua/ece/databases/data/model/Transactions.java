package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

enum PaymentMethod {
    cash,
    card
}

public class Transactions {
    private Timestamp dateTime;
    private Long  cardNumber;
    private float totalCost;
    private PaymentMethod paymentMethod;
    private Contains transactionContains;

    public Contains getTransactionContains() {
        return transactionContains;
    }

    public void setTransactionContains(Contains transactionContains) {
        this.transactionContains = transactionContains;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
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

    public gr.ntua.ece.databases.data.model.PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(gr.ntua.ece.databases.data.model.PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Transactions(){
        
    }

    /*
    public Transactions(Timestamp dateTime, Long cardNumber, float totalCost, gr.ntua.ece.databases.data.model.PaymentMethod paymentMethod, Contains transactionContains) {
        this.dateTime = dateTime;
        this.cardNumber = cardNumber;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
        this.transactionContains = transactionContains;
    }

     */
}