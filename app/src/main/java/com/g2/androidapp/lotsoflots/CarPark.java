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


    private String location;
    private double vacancy;
    CarPark(){ int vacancies = 0; }

    CarPark(double lat, double lng){}





    /** Method to get location in the CarPark class */
    public String getLocation(){
        return location;
    }


    /** Method to set location in the CarPark class */

    public void setLocation(String Location){
        this.location = Location;
    }

    /** Method to get number of Vacancies within CarPark*/
    public double getVacancy(){
        return vacancy;

    }

    /** Method to set number of vacancies within CarPark */

    public void setVacancy(double vacancy){
        this.vacancy = vacancy;
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

