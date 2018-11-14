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
                Toast.makeText(AboutActivity.this, "\"That's what she said.\"", Toast.LENGTH_SHORT).show();
            }
        });

        gwyneth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "\"Get a fish and you eat for a day. Learn to fish and you'll eat forever.\"", Toast.LENGTH_SHORT).show();
            }
        });

        janssen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "\"What happens in the room stays in the room.\"", Toast.LENGTH_SHORT).show();
            }
        });

        milla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "\"Don't cry because it happened, smile because its over.\"", Toast.LENGTH_SHORT).show();
            }
        });

        shenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "\"The credit belongs to the man in the arena.\"", Toast.LENGTH_SHORT).show();
            }
        });

        vincent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "\"You're the snack I want.\"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
