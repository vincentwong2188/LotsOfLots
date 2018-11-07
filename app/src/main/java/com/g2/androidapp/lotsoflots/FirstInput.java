package com.g2.androidapp.lotsoflots;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FirstInput extends AppCompatActivity {

    EditText name, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_input);
        name = (EditText) findViewById(R.id.BookmarkName);
        address = (EditText) findViewById(R.id.Address);
        Button DoneBtn = (Button) findViewById(R.id.DoneBtn);
        DoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void saveInfo(View view) {

        SharedPreferences namePreference = getSharedPreferences("UserAddress", MODE_PRIVATE);
        SharedPreferences.Editor nameEditor = namePreference.edit();
        nameEditor.putString("User", name.getText().toString());
        nameEditor.putString("OffAdd", address.getText().toString());
        nameEditor.commit();
    }

}
