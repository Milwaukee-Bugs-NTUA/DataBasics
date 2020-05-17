package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

enum PaymentMethod {
    cash,
    card
}

public class Transactions {
    private Timestamp dateTime;
    private long  cardNumber;
    private float totalCost;
    private PaymentMethod paymentMethod;

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
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

    public Transactions(Timestamp dateTime, long cardNumber, float totalCost, gr.ntua.ece.databases.data.model.PaymentMethod paymentMethod) {
        this.dateTime = dateTime;
        this.cardNumber = cardNumber;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
    }
}