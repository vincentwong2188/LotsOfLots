package com.g2.androidapp.lotsoflots;

import android.annotation.SuppressLint;

import java.sql.Time;
import java.util.*;


public class Preference {
    private int distance, vacancy;
    private String time ;
    private  String sort;
    public Preference(){

    }
    /** setting distance in preference*/
    public void setDistance(String distance) {
        switch(distance){
            case "Lesser than 100m":
                this.distance = 100;
                break;
            case "Lesser than 500m":
                this.distance = 500;
                break;
            case "Lesser than 1km":
                this.distance = 1000;
                break;
        }

    }
    /** getting the distance in Preference */
    public double getDistance() {
        return distance;

    }

    /** setting price in preference*/

    public void setVacancy(String Vacancy) {
        switch(Vacancy) {
            case "Lesser than 10 free lots":
                this.vacancy = 10;
                break;
            case "Lesser than 50 free lots":
                this.vacancy = 50;
                break;
            case "Lesser than 200 free lots":
                this.vacancy = 200;
                break;

        }
    }

    /** getting the price in Preference */

    public double getVacancy() {
        return vacancy;

    }
    public void setSort(String sort) {
        this.sort = sort;
    }

    /** getting the price in Preference */

    public String getSort() {
        return sort;

    }

    /** setting Time in preference*/

    @SuppressLint("DefaultLocale")
    public void setTime(int hour, int minute) {

        this.time = String.format("%2d%02d", hour, minute);;
    }

    /** getting the time in Preference */
    public String getTime() {
        return time;

    }





}
