package com.g2.androidapp.lotsoflots;

public class Bookmark {


    protected double lng;
    protected double lat;

    Bookmark (double lng, double lat){
    }

    /** Method to get longitude and latitude in the Bookmark */
    public double getlng(){ return lng; }
    public double getlat(){return lat;}



    /** Method to set longitude and latitude in the Bookmark*/

    public void setLng (double lng){ this.lng = lng; }
    public void setLat (double lat) {this.lat = lat;}

}