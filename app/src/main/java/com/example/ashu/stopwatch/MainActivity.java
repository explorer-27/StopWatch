package com.example.ashu.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button startButton,stopButton,resetButton,resumeButton,lapButton;
    TextView totalTimer,lapTimer;

    int seconds=0;boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         startButton =findViewById(R.id.startButton);
        stopButton =findViewById(R.id.stopButton);
        resetButton =findViewById(R.id.resetButton);
        resumeButton =findViewById(R.id.resumeButton);
        lapButton =findViewById(R.id.lapButton);

        totalTimer=findViewById(R.id.totalTimer);
        lapTimer=findViewById(R.id.lapTimer);
        runTimer();
    }

    public void startClicked(View view) {
        startButton.setVisibility(View.INVISIBLE);
        stopButton.setVisibility(View.VISIBLE);
        lapButton.setVisibility(View.VISIBLE);

        running=true;
    }
    public void stopClicked(View view) {
        stopButton.setVisibility(View.INVISIBLE);
        lapButton.setVisibility(View.INVISIBLE);
        resumeButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.VISIBLE);

        running=false;
    }
    public void resumeClicked(View view) {

        stopButton.setVisibility(View.VISIBLE);
        lapButton.setVisibility(View.VISIBLE);
        resumeButton.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);

        running=true;


    }
    public void resetClicked(View view) {
        resetButton.setVisibility(View.INVISIBLE);
        resumeButton.setVisibility(View.INVISIBLE);
        startButton.setVisibility(View.VISIBLE);

        running=false;
        seconds=0;
    }
    public void lapClicked(View view) {


    }
    public void runTimer(){

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours,mins,secs,milisecs;
                hours=seconds/3600;
                mins=(seconds%3600)/60;
                secs=seconds%60;
                milisecs=00;

                String time=String.format("%02d:%02d.%02d",mins,secs,milisecs);

                totalTimer.setText(time);
                if(running){

                    seconds++;
                }
                handler.postDelayed(this,1000);

            }
        });



    }
}
