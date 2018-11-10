package com.g2.androidapp.lotsoflots;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private BottomSheetBehavior mBottomSheetBehavior;
    private GeoDataClient mGeoDataClient;
    private SearchSuggestion mSearchSuggestion;
    private ArrayList<CarPark> listToDisplay = new ArrayList<>(0);
    private FusedLocationProviderClient mFusedLocationClient = null; // location provider
    private Location currentLocation = null;

    final int LOCATION_PERMISSION_REQUEST_CODE = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        final FloatingSearchView mSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);

        mSearchView.setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_filter:
                        startActivity(new Intent(MapsActivity.this, Filter.class));
                        break;
                    case R.id.action_bookmarks:
                        startActivity(new Intent(MapsActivity.this, BookmarkPage.class));
                        break;
                        //return true;
                    default:
                        //return super.onOptionsItemSelected(item);
                }
            }
        });

        try{
            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {

                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        currentLocation = location;
                    }
                }

            });
        }catch(SecurityException e){
            e.printStackTrace();
        }



        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                //get suggestions based on newQuery

                //pass them on to the search view
                //mSearchView.swapSuggestions(mSearchSuggestion);
            }
        });



        APIRetrieveSystem.retrieveCarParks(this);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Intent receivedIntent = getIntent();
        //String sTargetLocation = receivedIntent.getStringExtra(""); //TODO: add in key for location from bookmarks
        Location targetLocation = new Location("");

        if(targetLocation == null){
            if(currentLocation != null){
                targetLocation = currentLocation;
            }else{
                targetLocation.setLatitude(1.3493996);
                targetLocation.setLongitude(103.68721149999999);
            }

        }else{
            //String[] targetLocationBits = sTargetLocation.split(",");
            //targetLocation.setLatitude(Double.parseDouble(targetLocationBits[0]));
            //targetLocation.setLongitude(Double.parseDouble(targetLocationBits[1]));
        }

        searchLocation(targetLocation);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setPadding(0, pxToDP(70), 0, pxToDP(70));

        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        enableMyLocationIfPermitted();

        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng singapore = new LatLng(1.3521, 103.8198);

        for(int i = 0; i < listToDisplay.size(); i++){
            Marker mMarker;
            //mMarker = mMap.addMarker(new MarkerOptions().position(listToDisplay.get(i).getLocation()).title(listToDisplay.get(i).carpark_number));
            //mMarker.setTag(listToDisplay.get(i));
        }

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore,10));
    }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        CarPark cp = (CarPark) marker.getTag();



        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocationIfPermitted();
                } else {
                    showDefaultLocation();
                }
                return;
            }
        }
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    //mMap.setMinZoomPreference(15);
                    return false;
                }
            };


    private int pxToDP(int px){
        final float scale = findViewById(R.id.main_content).getContext().getResources().getDisplayMetrics().density;
        int dp = (int) (px * scale + 0.5f);
        return dp;
    }


    private void searchLocation(Location location){

        populateCarParkList();
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),10));
    }
    private void populateCarParkList(){
        View bottomSheet = findViewById( R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mBottomSheetBehavior.setPeekHeight(pxToDP(70));
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        LinearLayout scrollContents = findViewById(R.id.scrollContents);

        for(int i = 1; i <= 20 ; i++){
            LinearLayout itemLayout = new LinearLayout(this);

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            lp.setMargins(10,10,10,10);
            itemLayout.setLayoutParams(lp);
            itemLayout.setOrientation(LinearLayout.VERTICAL);

            TextView title = new TextView(this);
            TextView contents = new TextView(this);
            title.setText("Title " + i);
            title.setTypeface(title.getTypeface(), Typeface.BOLD_ITALIC);
            title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title.setPadding(5, 5, 5, 5);
            contents.setText("my text " + i);
            contents.setPadding(5, 5, 5, 20);
            itemLayout.addView(title);
            itemLayout.addView(contents);

            View v = new View(this);
            v.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    1
            ));
            v.setBackgroundColor(Color.parseColor("#B3B3B3"));
            itemLayout.addView(v);
            scrollContents.addView(itemLayout);
        }
    }
}
