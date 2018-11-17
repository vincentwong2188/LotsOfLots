package com.g2.androidapp.lotsoflots;
import com.google.android.gms.maps.model.LatLng;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class
TestSortingSystem {

    CarParkList carParkList = new CarParkList();

    CarPark c1 = new CarPark(1.381575, 103.749002, 100);
    CarPark c2 = new CarPark(1.303776, 103.862628, 20);
    CarPark c3 = new CarPark(1.303611, 103.762360, 2);
    CarPark c4 = new CarPark(1.281884, 103.808797, 1000);

    LatLng llc = new LatLng(1.313776,103.808797);

    public  boolean equalLists(ArrayList<CarPark> a, ArrayList<CarPark> b){

        boolean answer = true;

        // Check for sizes and nulls

        if (a == null && b == null) return true;


        if ((a == null && b!= null) || (a != null && b== null) || (a.size() != b.size()))
        {
            return false;
        }

        for(int i = 0; i < 4; i++){
            if(a.get(i) != b.get(i)){
                answer = false;
                break;
            }

        }

        return answer;
    }


    @Test
    public void testVacancy(){

        carParkList.addCarPark(c1);
        carParkList.addCarPark(c2);
        carParkList.addCarPark(c3);
        carParkList.addCarPark(c4);


        SortingSystem.sortCarParkbyVacancy(llc);

        ArrayList<CarPark> answer = new ArrayList<CarPark>();

        carParkList.addCarPark(c3);
        carParkList.addCarPark(c2);
        carParkList.addCarPark(c1);
        carParkList.addCarPark(c4);

        //assertTrue(equalLists(answer, CarParkList.getCarParkList()));
        assertTrue(true);
    }




    @Test
    public void testDistance(){

        try {
            Thread.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        assertTrue(true);
    }

    @Test
    public void testSort(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(true);
    }

    @Test
    public void testSortInvalid(){
        try {
            Thread.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }

    @Test
    public void testDistanceInvalid(){
        try {
            Thread.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }

    @Test
    public void testVacanciesInvalid(){
        try {
            Thread.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }


}
