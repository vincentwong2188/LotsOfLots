package com.g2.androidapp.lotsoflots;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Facade {

    private static Facade instance = null;
    private static String prevTime = null;

    private Facade(){
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public static ArrayList<CarPark> getSortedList(LatLng location, Context context){
        if(prevTime == null){
            prevTime = Preference.getTime();
            APIRetrieveSystem.retrieveall(context);
        }else if(!prevTime.equals(Preference.getTime())){
            APIRetrieveSystem.retrieveall(context);
            prevTime = Preference.getTime();
        }
        Log.d("Response", CarParkList.getCarParkList().size()+"");
        return SortingSystem.sortCarparks(location);
    }


}