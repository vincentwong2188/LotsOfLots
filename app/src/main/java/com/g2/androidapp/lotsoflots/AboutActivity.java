package com.g2.androidapp.lotsoflots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button darrence = (Button) findViewById(R.id.darrence);
        Button gwyneth = (Button) findViewById(R.id.gwyneth);
        Button janssen = (Button) findViewById(R.id.janssen);
        Button milla = (Button) findViewById(R.id.milla);
        Button shenc = (Button) findViewById(R.id.shenc);
        Button vincent = (Button) findViewById(R.id.vincent);

        darrence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Darrence Quote", Toast.LENGTH_SHORT).show();
            }
        });

        gwyneth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Gwyneth Quote", Toast.LENGTH_SHORT).show();
            }
        });

        janssen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Janssen Quote", Toast.LENGTH_SHORT).show();
            }
        });

        milla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Milla Quote", Toast.LENGTH_SHORT).show();
            }
        });

        shenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Shenc Quote", Toast.LENGTH_SHORT).show();
            }
        });

        vincent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Vincent Quote", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
