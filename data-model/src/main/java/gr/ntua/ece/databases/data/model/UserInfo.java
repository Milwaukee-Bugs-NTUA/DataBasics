package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Timestamp;

public class UserInfo {
    private List<CommonProduct> commonProducts;
    private List<CommonStore> commonStores;
    private List<HappyHour> happyHours;
    private Long meanTransactionsPerWeek;
    private Long meanTransactionsPerMonth;

    public UserInfo () {
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

    public List<HappyHour> getHappyHours() {
        return happyHours;
    }

    public List<CommonStore> getCommonStores() {
        return commonStores;
    }

    public List<CommonProduct> getCommonProducts() {
        return commonProducts;
    }

    public void setHappyHours(List<HappyHour> list) {
        this.happyHours = list;
    }

    public void setCommonStores(List<CommonStore> list) {
        this.commonStores = list;
    }

    public void setCommonProducts(List<CommonProduct> list) {
        this.commonProducts = list;
    } 
}