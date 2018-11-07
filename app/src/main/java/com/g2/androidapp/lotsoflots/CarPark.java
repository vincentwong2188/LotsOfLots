package com.g2.androidapp.lotsoflots;

public class CarPark {


    /** Location is repeated?? */

    private String location;
    private double vacancy;


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
