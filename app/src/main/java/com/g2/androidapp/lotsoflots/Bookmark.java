package com.g2.androidapp.lotsoflots;

public class Bookmark {
    protected double _long;
    protected double _lat;

    Bookmark (double _long, double _lat){
    }

    /** Method to get longitude and latitude in the Bookmark */
    public double get_long(){ return _long; }
    public double get_lat(){return _lat;}



    /** Method to set longitude and latitude in the Bookmark*/

    public void setLongitude (double _long){ this._long = _long; }
    public void setLatitude (double _lat) {this._lat = _lat;}

}