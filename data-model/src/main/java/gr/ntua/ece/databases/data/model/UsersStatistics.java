package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;

public class UsersStatistics {
    private Integer maximumSalesHourZone;
    private Float[] childrenPercentageOfConsumption;
    private Float[] adultsPercentageOfConsumption;
    private Float[] elderlyPercentageOfConsumption;

    public UsersStatistics() {
    }

    public Integer getMaximumSalesHourZone() {
        return maximumSalesHourZone;
    }

    public void setMaximumSalesHourZone(Integer hourZone) {
        this.maximumSalesHourZone = hourZone;
    }
    
}