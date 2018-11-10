//package com.g2.androidapp.lotsoflots;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlaceAutocomplete;
//import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
//import com.google.android.gms.location.places.ui.PlaceSelectionListener;
//
//public class TestAutoComplete extends AppCompatActivity {
//    private static final String TAG = "MainActivity";
//    int PLACE_AUTOCOMPLETE_REQUEST_CODE =1;
//    Place finalPlace;
//    HomePage homePage = new HomePage();
//    @Override
//    protected void onActivityResult(int requestCode , int resultCode, Intent data){
//        if(requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE){
//            if (resultCode == RESULT_OK){
//                Place place = PlaceAutocomplete.getPlace(this, data);
//                Log.i(TAG, "Ds" + place.getName());
//            }
//            else if (resultCode == PlaceAutocomplete.RESULT_ERROR){
//                Status status = PlaceAutocomplete.getStatus(this, data);
//            }
//        }
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_auto_complete);
//        Button DoneBtn = (Button) findViewById(R.id.DoneBtn);
//        DoneBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("location" , finalPlace.getLatLng().toString());
//                intent.putExtra("addressName" , finalPlace.getName().toString());
//                setResult(Activity.RESULT_OK , intent);
//                finish();
//            }
//        });
//
//        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
//                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
//        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
//            @Override
//            public void onPlaceSelected(Place place) {
//                // TODO: Get info about the selected place.
//                Log.i(TAG, "Location: " + place.getName());
//                Log.i(TAG, "Place: " + place.getLatLng());
//                finalPlace = place;
//            }
//
//            @Override
//            public void onError(Status status) {
//                // TODO: Handle the error.
//                Log.i(TAG, "An error occurred: " + status);
//            }
//        });
//    }
//}
