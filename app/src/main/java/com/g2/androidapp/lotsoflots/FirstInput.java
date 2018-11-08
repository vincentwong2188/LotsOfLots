package com.g2.androidapp.lotsoflots;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstInput extends AppCompatActivity {

    EditText name, address;
    String addressBkmk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_input);
        address = (EditText) findViewById(R.id.Address);
        Button DoneBtn = (Button) findViewById(R.id.DoneBtn);
        saveInfo();
        Toast toast = Toast.makeText(getApplicationContext(), addressBkmk, Toast.LENGTH_LONG);
        toast.show();
        DoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void saveInfo() {

        SharedPreferences namePreference = getSharedPreferences("UserAddress", MODE_PRIVATE);
        SharedPreferences.Editor nameEditor = namePreference.edit();
        // nameEditor.putString("User", name.getText().toString());
        nameEditor.putString("Address", address.getText().toString());
        nameEditor.commit();
        SharedPreferences bkmkAdd = PreferenceManager.getDefaultSharedPreferences(this);

        addressBkmk= bkmkAdd.getString("Address", "Not available");


    }
}
