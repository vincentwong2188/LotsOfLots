package com.g2.androidapp.lotsoflots;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Filter extends AppCompatActivity {
    String distance;
    String price;
    String time;Spinner distanceSpinner;Spinner priceSpinner;Spinner timeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        makeSpinner();
        String[] choice = obtainSelection();
        Button backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void makeSpinner(){

        distanceSpinner = (Spinner) findViewById(R.id.distanceSpinner);
        priceSpinner = (Spinner) findViewById(R.id.priceSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        ArrayAdapter<String> distanceAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.distanceSpinnerNames));
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        distanceSpinner.setAdapter(distanceAdapter);

        ArrayAdapter<String> priceAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.priceSpinnerNames));
        priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        priceSpinner.setAdapter(priceAdapter);

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.timeSpinnerNames));
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        timeSpinner.setAdapter(timeAdapter);
        }
        public String[] obtainSelection(){
            distanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    distance = distanceSpinner.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    return;
                }
            });
            timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    time = timeSpinner.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    return;
                }
            });
            priceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    price = priceSpinner.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    return;
                }
            });
            String[] choice = new String[3];
            choice[0] = distance;
            choice[1] = time;
            choice[2] = price;
            return choice;
    }
}
