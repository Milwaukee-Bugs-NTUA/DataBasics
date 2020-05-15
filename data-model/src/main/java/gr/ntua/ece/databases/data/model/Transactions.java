package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.*;

enum PaymentMethod {
    cash,
    card
}

public class Transactions {
    private dateTime datetime;
    private long  cardNumber;
    private float totalCost;
    private PaymentMethod paymentMethod;

    public dateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(dateTime datetime) {
        this.datetime = datetime;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
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

    public Transactions(dateTime datetime, long cardNumber, float totalCost, gr.ntua.ece.databases.data.model.PaymentMethod paymentMethod) {
        this.datetime = datetime;
        this.cardNumber = cardNumber;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
    }
}