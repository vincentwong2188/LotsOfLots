package com.g2.androidapp.lotsoflots;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TestAutoComplete extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int PLACE_AUTOCOMPLETE_REQUEST_CODE =1;
    private final static int REQUEST_CODE_1 = 1;
    Place finalPlace;
    BookmarkPage bookmarkPage = new BookmarkPage();
    SharedPreferences sharedPreferences;
    static int i = 0;
    private static Gson gson = new Gson();

    @Override
    protected void onActivityResult(int requestCode , int resultCode, Intent data){
        if(requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i(TAG, "Ds" + place.getName());
            }
            else if (resultCode == PlaceAutocomplete.RESULT_ERROR){
                Status status = PlaceAutocomplete.getStatus(this, data);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_auto_complete);
        SharedPreferences sharedPreferences = getSharedPreferences("bookmarkData",MODE_PRIVATE);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "TACLocation: " + place.getName());
                Log.i(TAG, "TACPlace: " + place.getLatLng());
                finalPlace = place;
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
    }

    public void printAddedBookmark(View view) {
        ArrayList<BookmarkData> bookmarkDataList;
        sharedPreferences = getSharedPreferences("bookmarkData",MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences("bookmarkData",MODE_PRIVATE).edit();

        String sharedPrefData = sharedPreferences.getString("bookmarkData","null");
        if (sharedPrefData.equals("null")){
            bookmarkDataList = new ArrayList<>();
        }
        else {
            bookmarkDataList = gson.fromJson(sharedPrefData,new TypeToken<ArrayList<BookmarkData>>(){}.getType());
        }

        Intent intent = new Intent(TestAutoComplete.this,BookmarkPage.class);
        BookmarkData bookmarkData = new BookmarkData(finalPlace.getLatLng().toString(),finalPlace.getName().toString());
        //BookmarkData bookmarkData = new BookmarkData(finalPlace.getLatLng(),finalPlace.getName().toString());
        //bookmarkDataList.add(new BookmarkData(finalPlace.getLatLng(),finalPlace.getName().toString()));
        bookmarkDataList.add(bookmarkData);

        // SharedPreferences.Editor editor = getSharedPreferences("bookmarkData",MODE_PRIVATE).edit();
//        editor.putString("bookmark",gson.toJson(bookmarkDataList));
//        editor.apply();
        storeBookmarks(editor,i,bookmarkDataList);
        i++;
        startActivity(intent);
    }

    public void storeBookmarks(SharedPreferences.Editor editor , int i, ArrayList<BookmarkData> bookmarkDataList){
        editor.putString("bookmarkData",gson.toJson(bookmarkDataList));
        editor.apply();

//        switch(i){
//            case 0:
//                editor.putString("bookmark1",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("1","1" );
//
//                break;
//            case 1:
//                editor.putString("bookmark2",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("2","2" );
//
//                break;
//            case 2:
//                editor.putString("bookmark3",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("3","3" );
//
//                break;
//            case 3:
//                editor.putString("bookmark4",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("4","4" );
//
//                break;
//            case 4:
//                editor.putString("bookmark5",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("5","5" );
//
//                break;
//
//            case 5:
//                editor.putString("bookmark5",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("6","6" );
//
//                break;
//
//            case 6:
//                editor.putString("bookmark5",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("7","7" );
//
//                break;
//
//            case 7:
//                editor.putString("bookmark5",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("8","8" );
//
//                break;
//
//            case 8:
//                editor.putString("bookmark5",gson.toJson(bookmarkDataList));
//                editor.apply();
//                Log.i("9","9" );
//
//                break;
//
//
//
//        }
    }

}
