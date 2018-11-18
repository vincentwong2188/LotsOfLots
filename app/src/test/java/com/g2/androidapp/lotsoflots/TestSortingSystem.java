package com.g2.androidapp.lotsoflots;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;



public class TestSortingSystem {

    //initialize mock data
    CarParkList carParkList = new CarParkList();
    CarPark c1 = new CarPark(1.381575, 103.749002, 100); //choachukang
    CarPark c2 = new CarPark(1.303776, 103.862628, 20); //bugis
    CarPark c3 = new CarPark(1.303611, 103.762360, 2); //clementi
    CarPark c4 = new CarPark(1.281884, 103.808797, 1000); //southern ridges
    CarPark c5 = new CarPark(1.314666, 103.807055, 150); //bot1
    CarPark c6 = new CarPark(1.313300, 103.808527, 1100); //bot2
    CarPark c7 = new CarPark(1.314169, 103.810606, 300); //bot3
    CarPark c8 = new CarPark(1.313776,103.808797, 10); //bot4

    //initialize mock location
    LatLng llc = new LatLng(1.313776,103.808797); //botanic gardens

    //initialize mock preferences
    Preference preference = new Preference();

    //checks if the arraylists are equal
    public  boolean equalLists(ArrayList<CarPark> a, ArrayList<CarPark> b){
        boolean answer = true;

        // Check for sizes and nulls
        if (a == null && b == null) return true;

        if ((a == null && b!= null) || (a != null && b== null) || (a.size() != b.size())) {
            return false;
        }

        for(int i = 0; i < a.size(); i++){
            if(a.get(i) != b.get(i)){
                answer = false;
                break;
            }
        }

        return answer;
    }


    @Test
    public void testVacancy(){

        carParkList.getCarParkList().clear();

        carParkList.addCarPark(c1);
        carParkList.addCarPark(c2);
        carParkList.addCarPark(c3);
        carParkList.addCarPark(c4);
        carParkList.addCarPark(c5);
        carParkList.addCarPark(c6);
        carParkList.addCarPark(c7);
        carParkList.addCarPark(c8);

        //initialize mock preferences
        preference.setDistance("Lesser than 100m");
        preference.setVacancy("More than 200 free lots");


        ArrayList<CarPark> sorted = SortingSystem.sortCarParkbyVacancy(llc);

        ArrayList<CarPark> answer = new ArrayList<CarPark>();
        answer.add(c6);
        answer.add(c4);
        answer.add(c7);



        boolean result = equalLists(answer, sorted);
        System.out.println(Boolean.toString(result));

        assertTrue(result);
    }




    @Test
    public void testDistance(){

        carParkList.getCarParkList().clear();

        carParkList.addCarPark(c1);
        carParkList.addCarPark(c2);
        carParkList.addCarPark(c3);
        carParkList.addCarPark(c4);
        carParkList.addCarPark(c5);
        carParkList.addCarPark(c6);
        carParkList.addCarPark(c7);
        carParkList.addCarPark(c8);

        //initialize mock preferences
        preference.setDistance("Lesser than 1km");
        preference.setVacancy("More than 1 free lots");


        ArrayList<CarPark> sorted = SortingSystem.sortCarParkbyDistance(llc);

        ArrayList<CarPark> answer = new ArrayList<CarPark>();
        answer.add(c4);
        answer.add(c6);
        answer.add(c7);

/*
        for(int i = 0; i < carParkList.getCarParkList().size(); i++) {
            System.out.println("the sorted list is: " + sorted.get(i).distance + " " + sorted.get(i).vacancies);
        }

        for(int i = 0; i < answer.size(); i++) {
            System.out.println("the answer list is: " + answer.get(i).vacancies);
        }
*/

        boolean result = equalLists(answer, sorted);
        System.out.println(Boolean.toString(result));

        assertTrue(result);
    }

    @Test
    public void testSortbp1(){

        carParkList.getCarParkList().clear();

        carParkList.addCarPark(c1);
        carParkList.addCarPark(c2);
        carParkList.addCarPark(c3);
        carParkList.addCarPark(c4);
        carParkList.addCarPark(c5);
        carParkList.addCarPark(c6);
        carParkList.addCarPark(c7);
        carParkList.addCarPark(c8);

        //initialize mock preferences
        preference.setDistance("Lesser than 1km");
        preference.setVacancy("More than 1 free lots");
        preference.setSort("Distance");

        ArrayList<CarPark> sorted = SortingSystem.sortCarparks(llc);

        ArrayList<CarPark> answer = new ArrayList<CarPark>();
        answer.add(c4);
        answer.add(c6);
        answer.add(c7);

/*
        for(int i = 0; i < carParkList.getCarParkList().size(); i++) {
            System.out.println("the sorted list is: " + sorted.get(i).distance + " " + sorted.get(i).vacancies);
        }

        for(int i = 0; i < answer.size(); i++) {
            System.out.println("the answer list is: " + answer.get(i).vacancies);
        }
*/

        boolean result = equalLists(answer, sorted);
        System.out.println(Boolean.toString(result));

        assertTrue(result);
    }

    @Test
    public void testSortbp2(){

        carParkList.getCarParkList().clear();

        carParkList.addCarPark(c1);
        carParkList.addCarPark(c2);
        carParkList.addCarPark(c3);
        carParkList.addCarPark(c4);
        carParkList.addCarPark(c5);
        carParkList.addCarPark(c6);
        carParkList.addCarPark(c7);
        carParkList.addCarPark(c8);

        //initialize mock preferences
        preference.setDistance("Lesser than 100m");
        preference.setVacancy("More than 200 free lots");
        preference.setSort("Vacancy");

        ArrayList<CarPark> sorted = SortingSystem.sortCarparks(llc);

        ArrayList<CarPark> answer = new ArrayList<CarPark>();
        answer.add(c6);
        answer.add(c4);
        answer.add(c7);



        boolean result = equalLists(answer, sorted);
        System.out.println(Boolean.toString(result));

        assertTrue(result);
    }




}
