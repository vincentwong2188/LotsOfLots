package com.g2.androidapp.lotsoflots;

import android.util.Log;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

public class SortingSystem {




    /** To sort Car Park List according to Proximity to User */

    public static ArrayList<CarPark> sortCarParkbyDistance(LatLng llc){

        /** Code first takes into account the user's filter of distance */

        Preference.setDistance("Lesser than 100m");


        double userDistance = Preference.getDistance();
        ArrayList<CarPark> temp = CarParkList.getCarParkList();
        ArrayList<CarPark> confirmed = new ArrayList<>();

        for (int k=0; k < temp.size(); k++){

            if (temp.get(k).calcDistance(llc) <= userDistance){
                confirmed.add(temp.get(k));
            }
        }

        for (int i=1; i< confirmed.size(); i++){

            for (int j=i ; j>0; j--){

                if (confirmed.get(j).calcDistance(llc) < confirmed.get(j-1).calcDistance(llc)){

                    CarPark temp2 = confirmed.get(j-1);
                    confirmed.set(j-1,confirmed.get(j));
                    confirmed.set(j,temp2);
                }
            }
        }


        for(int m = 0; m < confirmed.size(); m++)
        Log.d("Response","sorted carparks by distance is: " + confirmed.get(m).calcDistance(llc));

        return confirmed;
    }

    /** To sort Car Park List according to Vacancy Count */

    public static ArrayList<CarPark> sortCarParkbyVacancy(LatLng llc){

        /** Code first takes into account the user's filter of distance */

        double userDistance = Preference.getDistance();
        ArrayList<CarPark> temp = CarParkList.getCarParkList();
        ArrayList<CarPark> confirmed = new ArrayList<>();

        for (int k=0; k < temp.size(); k++ ){

            if (temp.get(k).calcDistance(llc) <= userDistance){
                confirmed.add(temp.get(k));
            }
        }

        /** Code then sorts the filtered Car Park list according to vacancy count*/

        for (int i=1; i< confirmed.size(); i++){

            for (int j=i ; j>0; j--){

                if (confirmed.get(j).getVacancy() > confirmed.get(j-1).getVacancy()){

                    CarPark temp2 = confirmed.get(j-1);
                    confirmed.set(j-1,confirmed.get(j));
                    confirmed.set(j,temp2);
                }
            }
        }
        return confirmed;

    }


}
