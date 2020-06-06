package gr.ntua.ece.databases.data.model;

import java.util.*;

public class HappyHour {
    private int hour;
    private int count;

    public HappyHour(){
    }

    public HappyHour(int hour, int count){
        this.hour = hour;
        this.count = count;
    }

    public int getHour() {
        return hour;
    }

    public int getCount() {
        return count;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setCount(int count) {
        this.count = count;
    }
}