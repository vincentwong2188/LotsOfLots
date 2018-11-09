package com.g2.androidapp.lotsoflots;

public class CarPark {




    /**  Attributes for APIRetrieveSystem   */
    protected String carpark_number;
    protected String carpark_address;
    protected float x_coord;
    protected float y_coord;
    protected double _long;
    protected double _lat;
    private double vacancy
            ;





    /** Method to get longitude and latitude in the CarPark class */
    public double get_long(){
        return _long;
    }
    public double get_lat() { return _lat; }


    /** Method to set longitude and latitude in the CarPark class */

    public void setLongitude (double _long){
        this._long = _long;
    }
    public void setLatitude (double _lat) {this._lat = _lat;}


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



    public LatLonCoordinate converter(float y_coord, float x_coord){
        CoordinateConverter convert2 = new  CoordinateConverter();
        return convert2.convert(y_coord, x_coord);

    }



}
