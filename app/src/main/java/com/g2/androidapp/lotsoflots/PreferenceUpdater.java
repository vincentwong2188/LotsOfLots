package com.g2.androidapp.lotsoflots;

import java.util.Date;

public class PreferenceUpdater {

    public static void updateAll(String distance, String vacancy, int hourFinal, int minuteFinal, Date date, String sort){
        setDistance(distance);
        setVacancy(vacancy);
        setTime(hourFinal, minuteFinal);
        setDate(date);
        setSort(sort);
    }

    public static void setDistance(String distance){
        Preference.setDistance(distance);
    }

    public static void setVacancy(String vacancy){
        Preference.setVacancy(vacancy);
    }

    public static void setTime( int hourFinal, int minuteFinal){
        Preference.setTime(hourFinal , minuteFinal);
    }

    public static void setDate(Date date){
        Preference.setDate(date);
    }


    public static void setSort(String sort){
        Preference.setSort(sort);
    }




}
