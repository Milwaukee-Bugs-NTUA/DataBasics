package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

enum PaymentMethod {
    cash,
    card
}

public class Transaction {
    private Timestamp datetime;
    private Long  cardNumber;
    private float totalCost;
    private PaymentMethod paymentMethod;
    private int numberOfProducts;
    private List<TransactionProduct> transactionProducts;

    public Transaction(){
    }

    public List<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(TransactionProduct transactionProducts) {
        this.transactionProducts = transactionProducts;
    }

    public Timestamp getDateTime() {
        return datetime;
    }

    public void setDateTime(Timestamp datetime) {
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

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }
}