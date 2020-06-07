package gr.ntua.ece.databases.data.model;

import java.util.*;

public class PercentageOfSuccess {
    private String categoryName;
    private Float percentage;

    public PercentageOfSuccess() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

}