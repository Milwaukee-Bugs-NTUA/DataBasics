package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;

public class ProductsStatistics {
    private List<OfferedInStore> topProductsPlacements;
    private float[] percentageOfSuccessInEachCategory;

    public ProductsStatistics() {
    }

    public List<OfferedInStore> getTopProductsPlacements() {
        return topProductsPlacements;
    }

    public void addTopProductPlacement(OfferedInStore topProductPlacement) {
        this.topProductsPlacements.add(topProductPlacement);
    }

    public void setTopProductsPlacements(List<OfferedInStore> topProductsPlacements) {
        this.topProductsPlacements = topProductsPlacements;
    }

    public float[] getPercentageOfSuccessInEachCategory() {
        return percentageOfSuccessInEachCategory;
    }

    public void setPercentageOfSuccessInEachCategory (float[] percentageOfSuccessInEachCategory) {
        this.percentageOfSuccessInEachCategory = percentageOfSuccessInEachCategory;
    }
}