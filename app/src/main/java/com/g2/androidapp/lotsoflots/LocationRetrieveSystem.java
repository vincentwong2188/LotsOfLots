//package com.g2.androidapp.lotsoflots;
//
//import android.location.Location;
//import android.os.Bundle;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.tasks.OnSuccessListener;
//
//public class LocationRetrieveSystem {
//
//    private FusedLocationProviderClient mFusedLocationClient = null; // location provider
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this); // register location provider
//    }
//
//    @Override
//    public void onMapReady(GoogleMap map) {
//        this.mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
//
//            @Override
//            public void onSuccess(Location location) {
//                // Got last known location. In some rare situations this can be null.
//                if (location != null) {
//                    // Logic to handle location object
//                    map.addMarker(new MarkerOptions().position(location).title("Marker"));
//                }
//            }
//
//        });
//    }
//
//}
