package gr.ntua.ece.databases.data.model;

import java.util.*;

public class Stores {
    private long storeID;
    private int size;
    private String addressCity;
    private String addressStreet;
    private int addressNumber;
    private String addressPostalCode;
    private Date openingHour;
    private Date closingHour;

    public long getStoreID() {
        return storeID;
    }

    public void setStoreID(long storeID) {
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

    public Date getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(Date openingHour) {
        this.openingHour = openingHour;
    }

    public Date getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(Date closingHour) {
        this.closingHour = closingHour;
    }

    public Stores() {

    }

    public Stores(long storeID, int size, String addressCity, String addressStreet, int addressNumber, String addressPostalCode, Date openingHour, Date closingHour) {
        this.storeID = storeID;
        this.size = size;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressPostalCode = addressPostalCode;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }
}