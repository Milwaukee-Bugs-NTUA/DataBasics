package gr.ntua.ece.databases.data.model;

import java.util.*;

public class PercentagesPerHour {
    private Float percentageOfYoung;
    private Float percentageOfMiddle;
    private Float percentageOfElder;
    private Integer hourZone;


    public PercentagesPerHour() {
    }

    public Float getPercentageOfYoung() {
        return percentageOfYoung;
    }

    public void setPercentageofYoung(Float percentageOfYoung) {
        this.percentageOfYoung = percentageOfYoung;
    }

    public Float getPercentageOfMiddle() {
        return percentageOfMiddle;
    }

    public void setPercentageofMiddle(Float percentageOfMiddle) {
        this.percentageOfMiddle = percentageOfMiddle;
    }

    public Float getPercentageOfElder() {
        return percentageOfElder;
    }

    public void setPercentageofElder(Float percentageOfElder) {
        this.percentageOfElder = percentageOfElder;
    }

    public Integer getHourZone() {
        return hourZone;
    }

    public void setHourZone(Integer hourZone) {
        this.hourZone = hourZone;
    }

}

