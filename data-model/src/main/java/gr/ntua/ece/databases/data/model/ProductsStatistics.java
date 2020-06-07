package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class ProductsStatistics {
    private List<ProductsPair> topProductsPairs;
    private List<ProductPlacement> topProductsPlacements;
    private List<PercentageOfSuccess> percentageOfSuccessInEachCategory;

    public ProductsStatistics() {
    }

    public List<ProductsPair> getTopProductsPairs() {
        return topProductsPairs;
    }

    public void setTopProductsPairs(List<ProductsPair> topProductsPairs) {
        this.topProductsPairs = topProductsPairs;
    }

    public List<PercentageOfSuccess> getPercentageOfSuccessInEachCategory() {
        return percentageOfSuccessInEachCategory;
    }

    public void setPercentageOfSuccessInEachCategory (List<PercentageOfSuccess> percentageOfSuccessInEachCategory) {
        this.percentageOfSuccessInEachCategory = percentageOfSuccessInEachCategory;
    }

    public List<ProductPlacement> getTopProductsPlacements() {
        return topProductsPlacements;
    }

    public void setTopProductsPlacements(List<ProductPlacement> topProductsPlacements) {
        this.topProductsPlacements = topProductsPlacements;
    }
}