package gr.ntua.ece.databases.data.model;

import java.util.*;
import java.sql.Time;

public class UsersStatistics {
    private Time startingHappyHour;
    private Time endingHappyHour;
    private float[] childrenPercentageOfConsumption;
    private float[] adultsPercentageOfConsumption;
    private float[] elderlyPercentageOfConsumption;

    public UsersStatistics() {
    }

    public Time getStartingHappyHour() {
        return startingHappyHour;
    }

    public void setStartingHappyHour(Time startingHappyHour) {
        this.startingHappyHour = startingHappyHour;
    }

    public Time getEndingHappyHour() {
        return endingHappyHour;
    }

    public void setEndingHappyHour(Time endingHappyHour) {
        this.endingHappyHour = endingHappyHour;
    }

    public float[] getChildrenPercentageOfConsumption() {
        return childrenPercentageOfConsumption;
    }

    public void setChildrenPercentageOfConsumption(float[] childrenPercentageOfConsumption) {
        this.childrenPercentageOfConsumption = childrenPercentageOfConsumption;
    }

    public float[] getAdultsPercentageOfConsumption() {
        return adultsPercentageOfConsumption;
    }

    public void setAdultsPercentageOfConsumption(float[] adultsPercentageOfConsumption) {
        this.adultsPercentageOfConsumption = adultsPercentageOfConsumption;
    }

    public float[] getElderlyPercentageOfConsumption() {
        return elderlyPercentageOfConsumption;
    }

    public void setElderlyPercentageOfConsumption(float[] elderlyPercentageOfConsumption) {
        this.elderlyPercentageOfConsumption = elderlyPercentageOfConsumption;
    }
}