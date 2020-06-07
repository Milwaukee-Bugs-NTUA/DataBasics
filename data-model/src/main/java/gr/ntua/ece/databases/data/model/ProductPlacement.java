package gr.ntua.ece.databases.data.model;

import java.util.*;

public class ProductPlacement {
    private String alleyNumber;
    private String selfNumber;

    public ProductPlacement() {
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