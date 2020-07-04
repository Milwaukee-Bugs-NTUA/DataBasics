package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;

public class UsersStatistics {
    private Integer maximumSalesHourZone;
    private List<PercentagesPerHour> percentagesPerHour;

    private List<UsersMaritalTransactions> maritalTransactions;
    private UsersParentalTransactions parentalTransactions;

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

    public List<UsersMaritalTransactions> getMaritalTransactions() {
        return maritalTransactions;
    }

    public void setMaritalTransactions(List<UsersMaritalTransactions> Mtrans) {
        this.maritalTransactions = Mtrans;
    }

    public UsersParentalTransactions getParentalTransactions() {
        return parentalTransactions;
    }

    public void setParentalTransactions(UsersParentalTransactions Ptrans){
        this.parentalTransactions = Ptrans;
    }

    
    
}