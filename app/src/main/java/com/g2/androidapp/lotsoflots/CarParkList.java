package com.g2.androidapp.lotsoflots;

import java.util.ArrayList; //where shld the import be at???

public class CarParkList {

    private int numberOfCarparks;
    private static ArrayList<CarPark> carparksArrayList = new ArrayList<CarPark>();

    CarParkList(){

    }

    public static void addCarPark(CarPark entry){
        carparksArrayList.add(entry);
    }

    public static int findCarpark(String carpark_no){
        int carparkindex = -1;
        for(int j = 0; j < carparksArrayList.size(); j++ ){
            if(carparksArrayList.get(j).carpark_number == carpark_no){
                carparkindex = j;
                break;
            }
        }
        return carparkindex;
    }

    public static void changeVacancy(int vacancy, int index){
        carparksArrayList.get(index).setVacancy(vacancy);
    }


 /*   public ArrayList<CarPark> getCarpark() {
        ArrayList<CarPark> carpark;
        carpark =
        return carpark;
    }*/

     public static ArrayList<CarPark> getCarParkList(){
         return carparksArrayList;
     }


}
