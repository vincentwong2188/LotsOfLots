package com.g2.androidapp.lotsoflots;

import android.util.Log;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

public class SortingSystem {

    /** To sort Car Park List according to Proximity to User */

    public static ArrayList<CarPark> sortCarParkbyDistance(LatLng llc){

        /** Code first takes into account the user's filter of distance */


        //double userDistance = Preference.getDistance();
        double userDistance = 1000;

        //int userVacancy = Preference.getVacancy();
        int userVacancy = 100;

        ArrayList<CarPark> temp = CarParkList.getCarParkList();
        ArrayList<CarPark> confirmed1 = new ArrayList<>();
        ArrayList<CarPark> confirmed2 = new ArrayList<>();



        for (int k=0; k < temp.size(); k++){

            if (temp.get(k).calcDistance(llc) <= userDistance){
                confirmed1.add(temp.get(k));
            }
        }


        for (int n=0; n < confirmed1.size(); n++){

            if (confirmed1.get(n).vacancies >= userVacancy){
                confirmed2.add(confirmed1.get(n));
            }
        }


        for (int i=1; i< confirmed2.size(); i++){

            for (int j=i ; j>0; j--){

                if (confirmed2.get(j).calcDistance(llc) < confirmed2.get(j-1).calcDistance(llc)){

                    CarPark temp2 = confirmed2.get(j-1);
                    confirmed2.set(j-1,confirmed2.get(j));
                    confirmed2.set(j,temp2);
                }
            }
        }


        for(int m = 0; m < confirmed2.size(); m++) {
            Log.d("Response", "sorted carparks by distance is: " + confirmed2.get(m).calcDistance(llc));
            Log.d("Response", "carpark vacancy is: " + confirmed2.get(m).vacancies);
            Log.d("Response", "sorted carparks by distance is: " + confirmed2.get(m).carpark_address);
        }


        return confirmed2;
    }

    /** To sort Car Park List according to Vacancy Count */

    public static ArrayList<CarPark> sortCarParkbyVacancy(LatLng llc){

        /** Code first takes into account the user's filter of distance */

        double userDistance = Preference.getDistance();
        //double userDistance = 1000;
        int userVacancy = Preference.getVacancy();
        //int userVacancy = 200;

        ArrayList<CarPark> temp = CarParkList.getCarParkList();
        ArrayList<CarPark> confirmed1 = new ArrayList<>();
        ArrayList<CarPark> confirmed2 = new ArrayList<>();


        /** Filters out carparks based on distance filter*/
        for (int k=0; k < temp.size(); k++ ){

            if (temp.get(k).calcDistance(llc) <= userDistance){
                confirmed1.add(temp.get(k));
            }
        }


        /** Filters out carparks based on vacancy filter*/
        for (int n=0; n < confirmed1.size(); n++){

            if (confirmed1.get(n).getVacancy() >= userVacancy){
                confirmed2.add(confirmed1.get(n));
            }
        }

        /** Code then sorts the filtered Car Park list according to vacancy count*/

        for (int i=1; i< confirmed2.size(); i++){

            for (int j=i ; j>0; j--){

                if (confirmed2.get(j).getVacancy() > confirmed2.get(j-1).getVacancy()){

                    CarPark temp2 = confirmed2.get(j-1);
                    confirmed2.set(j-1,confirmed2.get(j));
                    confirmed2.set(j,temp2);
                }
            }
        }

        for(int m = 0; m < confirmed2.size(); m++) {
            Log.d("Response", "sorted carparks by vacancy is: " + confirmed2.get(m).vacancies);
            Log.d("Response", "sorted carparks by vacancy address is: " + confirmed2.get(m).carpark_address);
        }
        return confirmed2;

    }


}
