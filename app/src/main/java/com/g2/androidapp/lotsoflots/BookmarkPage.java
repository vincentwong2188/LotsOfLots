package com.g2.androidapp.lotsoflots;
// autocomplete.getPlace().geometry.location --> https://stackoverflow.com/questions/10957649/google-maps-autocomplete-how-to-get-lat-lng
import android.content.Intent;
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
import android.widget.RelativeLayout;

public class BookmarkPage extends AppCompatActivity {

    String location;
    String addressName;
    String[] Addresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_page);
        final Intent intent = new Intent(this, TestAutoComplete.class);
        Button AddBookmark = (Button) findViewById(R.id.AddBkmk);
        AddBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent , 1014);
            }
        });
        bookmarkList();
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data){
        requestCode = 1014; resultCode = RESULT_OK;
        location = data.getStringExtra("location");
        addressName = data.getStringExtra("addressName") ;
        Log.i("location", location);
        Log.i("addressName" , addressName);

    }
    public void bookmarkList() {
        LinearLayout scrollContents = findViewById(R.id.scrollContents);
        for (int i = 1; i <=1; i++) {
            LinearLayout itemLayout = new LinearLayout(this);

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            lp.setMargins(10, 10, 10, 10);
            itemLayout.setLayoutParams(lp);
            itemLayout.setOrientation(LinearLayout.VERTICAL);

            Button title = new Button(this);
            //SharedPreferences bkmkAdd = PreferenceManager.getDefaultSharedPreferences(this);
            //String addressBkmk = bkmkAdd.getString("Address", "Not available");
            title.setText(addressName);
            title.setTypeface(title.getTypeface(), Typeface.BOLD_ITALIC);
            title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            title.setPadding(5, 5, 5, 5);
            itemLayout.addView(title);

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
