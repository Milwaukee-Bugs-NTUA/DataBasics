package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class ProductsStatistics {
    private List<ProductsPair> topProductsPairs;
    private List<ProductPlacement> topProductsPlacements;
    private float[] percentageOfSuccessInEachCategory;

    public ProductsStatistics() {
    }

    public List<ProductsPair> getTopProductsPairs() {
        return topProductsPairs;
    }

    public void setTopProductsPairs(List<ProductsPair> topProductsPairs) {
        this.topProductsPairs = topProductsPairs;
    }

    public float[] getPercentageOfSuccessInEachCategory() {
        return percentageOfSuccessInEachCategory;
    }

    public void setPercentageOfSuccessInEachCategory (float[] percentageOfSuccessInEachCategory) {
        this.percentageOfSuccessInEachCategory = percentageOfSuccessInEachCategory;
    }

    public List<ProductPlacement> getTopProductsPlacements() {
        return topProductsPlacements;
    }

    public void setTopProductsPlacements(List<ProductPlacement> topProductsPlacements) {
        this.topProductsPlacements = topProductsPlacements;
    }
}