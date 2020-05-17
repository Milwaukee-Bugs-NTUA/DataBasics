package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;

public class Stores {
    private Long storeID;
    private int size;
    private String addressCity;
    private String addressStreet;
    private int addressNumber;
    private String addressPostalCode;
    private Time openingHour;
    private Time closingHour;

    public Long getStoreID() {
        return storeID;
    }

    public void setStoreID(Long storeID) {
        this.storeID = storeID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public Time getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(Time openingHour) {
        this.openingHour = openingHour;
    }

    public Time getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(Time closingHour) {
        this.closingHour = closingHour;
    }

    public Stores() {

    }

    /*
    public Stores(Long storeID, int size, String addressCity, String addressStreet, int addressNumber, String addressPostalCode, Time openingHour, Time closingHour) {
        this.storeID = storeID;
        this.size = size;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressPostalCode = addressPostalCode;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

     */
}