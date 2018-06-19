package com.example.dell.sound_encryption;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Play_button extends AppCompatActivity {
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_button);
        //final Button btn = (Button) findViewById(R.id.btn);
        final FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.btn);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.beepi);
        final TextView tv = (TextView) findViewById(R.id.tv);
        final ProgressBar pb = (ProgressBar) findViewById(R.id.pb);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the progress status zero on each button click

                progressStatus = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < 100){
                            // Update the progress status
                            progressStatus +=1;
                            mp.start();

                            // Try to sleep the thread for 20 milliseconds
                            try{
                                Thread.sleep(60);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb.setProgress(progressStatus);
                                    // Show the progress on TextView
                                    tv.setText(progressStatus+"");
                                }
                            });
                        }
                    }
                }).start(); // Start the operation
            }
        });

    }
}
