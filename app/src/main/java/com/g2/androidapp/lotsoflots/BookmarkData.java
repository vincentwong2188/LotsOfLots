package com.g2.androidapp.lotsoflots;


public class BookmarkData {
    String latlng;
    //LatLng latlng;
    String name;

    BookmarkData(String latLng, String name) {
        this.latlng = latLng;
        this.name = name;
    }

    /*BookmarkData(LatLng latLng, String name) {
        this.latlng = latLng;
        this.name = name;
    }*/

    public String getName() {
        return name;
    }

    public String getLatlng() {
        return latlng;
    }
}