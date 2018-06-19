package com.example.dell.sound_encryption;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class Receive extends AppCompatActivity {
    ImageButton imgbtn;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
         imgbtn =(ImageButton)findViewById(R.id.mikeButton);
        spinner=(ProgressBar)findViewById(R.id.circularprogressBaring);

        spinner.setVisibility(View.GONE);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent Intent = new Intent(Receive.this, Output.class);
                        startActivity(Intent);
                    }
                }, 16000);

            }
        });

    }
}
