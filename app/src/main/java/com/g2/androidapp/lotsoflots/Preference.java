package com.g2.androidapp.lotsoflots;

import android.annotation.SuppressLint;

import java.sql.Time;
import java.util.*;


public class Preference {
    private static double distance;
    private static int vacancy;
    private static String time ;
    private static String sort;

    public Preference(){

    }

    /** set time for API testing*/

    public static void setTime(String times){
        time = times;
    }

    /** setting distance in preference*/
    public static void setDistance(String dist) {
        switch(dist){
            case "Lesser than 100m":
                distance = 100;
                break;
            case "Lesser than 500m":
                distance = 500;
                break;
            case "Lesser than 1km":
                distance = 1000;
                break;
        }

    }
    /** getting the distance in Preference */
    public static double getDistance() {
        return distance;

    }

    /** setting price in preference*/

    public static void setVacancy(String Vacancy) {
        switch(Vacancy) {
            case "More than 10 free lots":
                vacancy = 1;
                break;
            case "More than 50 free lots":
                vacancy = 50;
                break;
            case "More than 200 free lots":
                vacancy = 200;
                break;

        }
    }

    /** getting the price in Preference */

    public static int getVacancy() {
        return vacancy;

    }
    public static void setSort(String sorts) {

        switch (sorts) {
            case "Distance":
                sort = "Distance";
                break;
            case "Vacancy":
                sort = "Vacancy";
                break;

        }
    }


    public static String getSort(){
            return sort;
        }

    /** setting Time in preference*/

    @SuppressLint("DefaultLocale")
    public void setTime(int hour,int minute) {

        this.time = String.format("%2d%02d", hour, minute);;
    }

    /** getting the time in Preference */
    public static String getTime() {
        return time;

    }





}


