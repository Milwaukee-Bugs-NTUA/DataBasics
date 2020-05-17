package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class OfferedInStore {
    private Long storeId;
    private String alleyNumber;
    private String selfNumber;

    public OfferedInStore(Long storeId, String alleyNumber, String selfNumber) {
        this.storeId = storeId;
        this.alleyNumber = alleyNumber;
        this.selfNumber = selfNumber;
    }

    public OfferedInStore() {
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getAlleyNumber() {
        return alleyNumber;
    }

    public void setAlleyNumber(String alleyNumber) {
        this.alleyNumber = alleyNumber;
    }

    public String getSelfNumber() {
        return selfNumber;
    }

    public void setSelfNumber(String selfNumber) {
        this.selfNumber = selfNumber;
    }
}