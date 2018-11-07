package com.g2.androidapp.lotsoflots;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button SearchBtn = (Button) findViewById(R.id.SearchBtn);
        final Intent intent = new Intent(this, FirstInput.class);
        final Intent toMaps = new Intent(this, MapsActivity.class);

        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toMaps);
            }
        });

        Button AddBookmark = (Button) findViewById(R.id.AddBkmk);
        AddBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

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
