package com.g2.androidapp.lotsoflots;

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
    CarPark(){
        int vacancies = 0;
    }



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

    public Double calcDistance(){
        Double a = 0.0;
        return a;
    }

}

