package com.g2.androidapp.lotsoflots;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class CarPark {

    /**  Attributes for APIRetrieveSystem   */
    protected String carpark_number;
    protected String carpark_address;
    protected float x_coord;
    protected float y_coord;
    protected double lat;
    protected double lng;
    protected int vacancies;
    protected int capacity;


    private String location;

    CarPark(){ int vacancies = 0; }

/*
    CarPark(double lat, double lng){}

*/


    CarPark(String number, String address, float x, float y){
        carpark_number = number;
        carpark_address = address;
        x_coord = x;
        y_coord = y;
        lat = CoordinateConverter.convert(y_coord, x_coord).getLatitude();
        lng = CoordinateConverter.convert(y_coord, x_coord).getLongitude();
        vacancies = 0;

    }
    CarPark(String number, String address, float x, float y, int vac){
        carpark_number = number;
        carpark_address = address;
        x_coord = x;
        y_coord = y;
        lat = CoordinateConverter.convert(y_coord, x_coord).getLatitude();
        lng = CoordinateConverter.convert(y_coord, x_coord).getLongitude();
        vacancies = vac;
    }



    /** Method to get location in the CarPark class */
    public LatLonCoordinate getLocation(){
        LatLonCoordinate latlonobject = new LatLonCoordinate(lat, lng);
        return latlonobject;
    }

    public String getName(){
        return carpark_number;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int cap){
        capacity = cap;
    }


    /** Method to set location in the CarPark class */

 /*   public void setLocation(String Location){
        this.location = Location;
    }
*/

    /** Method to get number of Vacancies within CarPark*/
    public double getVacancy(){
        return vacancies;

    }

    /** Method to set number of vacancies within CarPark */

    public void setVacancy(int vacancy){
        vacancies = vacancy;
    }



public  float calcDistance(LatLonCoordinate currentloc){
    Location currentloc2 = new Location("");
    currentloc2.setLatitude(currentloc.getLatitude());
    currentloc2.setLongitude(currentloc.getLongitude());


    Location carparkloc = new Location("");
    carparkloc.setLatitude(lat);
    carparkloc.setLongitude(lng);


    return carparkloc.distanceTo(currentloc2);


}





}

