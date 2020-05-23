package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class UserInfo {
    private List<Long> commonProductsId;
    private List<String> commonProductsNames;
    private List<Long> commonStoresId;
    private List<String> commonStoresNames;
    private List<Time> happyHoursEntry;
    private List<Time> happyHoursDeparture;
    private Long meanTransactionsPerWeek;
    private Long meanTransactionsPerMonth;

    private UserInfo userInfo;

    public UserInfo () {
    }

    public List<Long> getCommonProductsId() {
        return commonProductsId;
    }

    public void addCommonProductId (Long commonProductId) {
        this.commonProductsId.add(commonProductId);
    }

    public void setCommonProductsId(List<Long> commonProductsId) {
        this.commonProductsId = commonProductsId;
    }

    public List<String> getCommonProductsNames() {
        return commonProductsNames;
    }

    public void addCommonProductName (String commonProductName) {
        this.commonProductsNames.add(commonProductName);
    }

    public void setCommonProductsNames(List<String> commonProductsNames) {
        this.commonProductsNames = commonProductsNames;
    }

    public List<Long> getCommonStoresId() {
        return commonStoresId;
    }

    public void addCommonStoreId (Long commonStoreId) {
        this.commonStoresId.add(commonStoreId);
    }

    public void setCommonStoresId(List<Long> commonStoresId) {
        this.commonStoresId = commonStoresId;
    }

    public List<String> getCommonStoresNames() {
        return commonStoresNames;
    }

    public void addCommonStoreName (String commonStoreName) {
        this.commonStoresNames.add(commonStoreName);
    }

    public void setCommonStoresNames(List<String> commonStoresNames) {
        this.commonStoresNames = commonStoresNames;
    }

    public Long getMeanTransactionsPerWeek() {
        return meanTransactionsPerWeek;
    }

    public void setMeanTransactionsPerWeek(Long meanTransactionsPerWeek) {
        this.meanTransactionsPerWeek = meanTransactionsPerWeek;
    }

    public Long getMeanTransactionsPerMonth() {
        return meanTransactionsPerMonth;
    }

    public void setMeanTransactionsPerMonth(Long meanTransactionsPerMonth) {
        this.meanTransactionsPerMonth = meanTransactionsPerMonth;
    }

    public gr.ntua.ece.databases.data.model.UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(gr.ntua.ece.databases.data.model.UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}