package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

public class PriceHistory {
    private Timestamp startingDate;
    private long barcode;
    private Timestamp endingDate;
    private float oldPrice;

    public Timestamp getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Timestamp startingDate) {
        this.startingDate = startingDate;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public Timestamp getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Timestamp endingDate) {
        this.endingDate = endingDate;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public PriceHistory() {

    }

    public PriceHistory(Timestamp startingDate, long barcode, Timestamp endingDate, float oldPrice) {
        this.startingDate = startingDate;
        this.barcode = barcode;
        this.endingDate = endingDate;
        this.oldPrice = oldPrice;
    }
}
