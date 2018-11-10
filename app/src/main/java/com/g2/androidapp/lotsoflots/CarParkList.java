package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;

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
            if(carparksArrayList.get(j).carpark_number.equals(carpark_no)){
                carparkindex = j;
                break;
            }
        }
        return carparkindex;
    }

    public static void changeVacancy(int vacancy, int index){
        carparksArrayList.get(index).setVacancy(vacancy);
    }

    public static void setCapacity(int cap, int index){
        carparksArrayList.get(index).setCapacity(cap);
    }



    public static ArrayList<CarPark> getCarParkList(){
        return carparksArrayList;
    }


}
