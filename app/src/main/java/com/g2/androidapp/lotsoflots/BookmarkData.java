package com.g2.androidapp.lotsoflots;

import com.google.android.gms.maps.model.LatLng;

public class BookmarkData {
    LatLng latlng;
    String name;

    BookmarkData(LatLng latLng, String name) {
        this.latlng = latLng;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}