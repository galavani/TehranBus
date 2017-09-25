package com.example.zuut.tehranbus.Model;

/**
 * Created by z.uut on 12/25/2016.
 */

public class Moves {

    private int id;
    private int id_station;
    private String time;
    private String day;

    public  Moves(int id,int id_station,String time,String day){
        this.id=id;
        this.id_station=id_station;
        this.time=time;
        this.day=day;


    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
