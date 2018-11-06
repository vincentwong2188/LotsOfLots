package com.g2.androidapp.lotsoflots;

import android.graphics.Typeface;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        FloatingSearchView mSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);

        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                //get suggestions based on newQuery

                //pass them on to the search view
                //mSearchView.swapSuggestions();
            }
        });

        View bottomSheet = findViewById( R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mBottomSheetBehavior.setPeekHeight(200);
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
            contents.setPadding(5, 5, 5, 5);
            itemLayout.addView(title);
            itemLayout.addView(contents);
            scrollContents.addView(itemLayout);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera

        ArrayList<LatLng> carparks = new ArrayList<>(0);

        LatLng singapore = new LatLng(1.3521, 103.8198);

        for(int i = 0; i < carparks.size(); i++){
            mMap.addMarker(new MarkerOptions().position(carparks.get(i)).title("Marker No. " + i));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(singapore));
        }

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore,10));
    }
}
