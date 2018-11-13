package com.g2.androidapp.lotsoflots;
// autocomplete.getPlace().geometry.location --> https://stackoverflow.com/questions/10957649/google-maps-autocomplete-how-to-get-lat-lng
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookmarkPage extends AppCompatActivity {

    String location;
    String addressName;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private static Gson gson = new Gson();
    ListView listView;
    BookmarkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_page);
        listView = findViewById(R.id.bookmark_list);
        adapter = new BookmarkAdapter(this,R.layout.bookmark_list_item);
        listView.setAdapter(adapter);

        sharedPreferences = getSharedPreferences("bookmarkData",MODE_PRIVATE);

        Button DeleteBookmark = (Button) findViewById(R.id.DeleteBtn);
        DeleteBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       Button ReturnHome = (Button) findViewById(R.id.ReturnHomeBtn);
        ReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookmarkPage.this, MapsActivity.class));
            }
        }); 
    }

    @Override
    protected void onResume(){
        super.onResume();
        bookmarkList();
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data){
   //     requestCode = 1014; resultCode = RESULT_OK;
//        location = data.getStringExtra("location");
//        addressName = data.getStringExtra("addressName") ;
//        Log.i("location", location);
//        Log.i("addressName" , addressName);

    }
    public void bookmarkList() {
        LinearLayout scrollContents = findViewById(R.id.scrollContents);
        ArrayList<BookmarkData> bookmarkDataList = new ArrayList<>();
        List<String> bookmarkData = new ArrayList<>();

        String preferenceData = sharedPreferences.getString("bookmarkData","Not available");
        Log.d("Bookmark",preferenceData);


        if (preferenceData != "Not available" && preferenceData != "") {
            bookmarkDataList = gson.fromJson(preferenceData,new TypeToken<List<BookmarkData>>(){}.getType());
        }

        for (BookmarkData data : bookmarkDataList){
            bookmarkData.add(data.getName());
        }

        BookmarkAdapter adapter = new BookmarkAdapter(getApplicationContext(),R.layout.bookmark_list_item,bookmarkDataList);
        listView.setAdapter(adapter);
        listView.invalidate();
    }


    public void launchTestAutoComplete(View view) {
        Log.d(LOG_TAG, "Add Bookmark Button clicked!");
        Intent intent = new Intent(this, TestAutoComplete.class);
        startActivityForResult(intent,1014);

    }

}
