package gr.ntua.ece.databases.data.model;

import java.util.*;

public class CommonStore {
    private Long storeID;
    private String storeName;

    public CommonStore(){
    }

    public CommonStore(Long storeID, String storeName){
        this.storeID = storeID;
        this.storeName = storeName;
    }

    public Long getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreID(Long storeID) {
        this.storeID = storeID;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}