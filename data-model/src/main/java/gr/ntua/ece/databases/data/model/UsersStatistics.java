package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;

public class UsersStatistics {
    private Integer maximumSalesHourZone;
    private List<PercentagesPerHour> percentagesPerHour;

    public UsersStatistics() {
    }

    public List<PercentagesPerHour> getPercentagesPerHour() {
        return percentagesPerHour;
    }

    public void setPercentagesPerHour(List<PercentagesPerHour> ppHour) {
        this.percentagesPerHour = ppHour;
    }

    public Integer getMaximumSalesHourZone() {
        return maximumSalesHourZone;
    }

    public void setMaximumSalesHourZone(Integer hourZone) {
        this.maximumSalesHourZone = hourZone;
    }
    
}