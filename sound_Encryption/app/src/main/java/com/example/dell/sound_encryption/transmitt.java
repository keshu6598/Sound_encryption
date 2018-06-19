package com.example.dell.sound_encryption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class transmitt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmitt);
        Button buttoni= (Button) findViewById(R.id.generatebtn);

        buttoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentntent = new Intent(transmitt.this, Play_button.class);
                transmitt.this.startActivity(intentntent);
            }
        });

    }
}
