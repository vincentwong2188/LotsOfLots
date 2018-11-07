package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;

public class SortingSystem {

    private ArrayList<CarPark> carparks;

    public SortingSystem() {

        /*

        carparks = new ArrayList<carParkList>(0);
        vacantCarparks = new ArrayList<vacancyList>(0);

        */

    }

    public ArrayList<CarPark> sortCarParkbyDistance(ArrayList<CarPark> carparks){

        for (int i=1; i< carparks.size(); i++){

            for (int j=1 ; j>0; j++){

                if (carparks.get(j).calcDistance() < carparks.get(j-1).calcDistance()){

                    CarPark temp = carparks.get(j-1);
                    carparks.set(j-1,carparks.get(j));
                    carparks.set(j,temp);

                }

            }

        }

        return carparks;





    }

    public ArrayList<CarPark> sortCarParkbyVacancy(ArrayList<CarPark> carparks){

        for (int i=1; i< carparks.size(); i++){

            for (int j=1 ; j>0; j++){

                if (carparks.get(j).getVacancy() < carparks.get(j-1).getVacancy()){

                    CarPark temp = carparks.get(j-1);
                    carparks.set(j-1,carparks.get(j));
                    carparks.set(j,temp);

                }

            }

        }

        return carparks;





    }


}
