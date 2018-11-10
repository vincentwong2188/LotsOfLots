package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;

public class SortingSystem {


    /** To sort Car Park List according to Proximity to User */

    public static ArrayList<CarPark> sortCarParkbyDistance(LatLonCoordinate llc){

        /** Code first takes into account the user's filter of distance */

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
        return confirmed;
    }

    /** To sort Car Park List according to Vacancy Count */

    public static ArrayList<CarPark> sortCarParkbyVacancy(LatLonCoordinate llc){

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
