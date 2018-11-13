package com.g2.androidapp.lotsoflots;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Facade {

    private static Facade instance = null;

    private Facade(){
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public static ArrayList<CarPark> getSortedList(LatLng location, Context context){
        APIRetrieveSystem.retrieveall(context);
        return SortingSystem.sortCarparks(location);
    }


}






