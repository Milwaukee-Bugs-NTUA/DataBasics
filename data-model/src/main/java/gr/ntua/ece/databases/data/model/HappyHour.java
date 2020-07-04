package gr.ntua.ece.databases.data.model;

import java.util.*;

public class HappyHour {
    private int hour;
    private float count;

    public HappyHour(){
    }

    public HappyHour(int hour, int count){
        this.hour = hour;
        this.count = count;
    }

    public int getHour() {
        return hour;
    }

    public float getCount() {
        return count;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setCount(float count) {
        this.count = count;
    }
}