package com.example.ashu.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button startButton,stopButton,resetButton,resumeButton,lapButton;
    TextView totalTimer;

    public static int previousMiliseconds,lapTime,sNo,miliseconds =0;boolean running;
    String totaltime ,lapTimeText="";
    ImageView img;

    public static ListView listView;
    public LapsAdapter mLapsAdapter;
    public static ArrayList<Laps> mLapsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         startButton =findViewById(R.id.startButton);
        stopButton =findViewById(R.id.stopButton);
        resetButton =findViewById(R.id.resetButton);
        resumeButton =findViewById(R.id.resumeButton);
        lapButton =findViewById(R.id.lapButton);
        img=findViewById(R.id.imageView);
        listView =(ListView) findViewById(R.id.lapViews);
        mLapsData=new ArrayList<Laps>();
        mLapsAdapter=new LapsAdapter(this,mLapsData);


        totalTimer=findViewById(R.id.totalTimer);
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
        img.setVisibility(View.VISIBLE);
        running=false;
        miliseconds =0;previousMiliseconds=0;sNo=0;
        mLapsData=new ArrayList<Laps>();

        mLapsAdapter=new LapsAdapter(this,mLapsData);
        listView.setAdapter(mLapsAdapter);
    }


    public void lapClicked(View view) {
        img.setVisibility(View.GONE);
        if(previousMiliseconds==0){
            lapTime=miliseconds-previousMiliseconds-100;
            sNo=1;
        }
        else {
            lapTime = miliseconds - previousMiliseconds;
            sNo+=1;
        }int laphours,lapmins,lapsecs,lapmilisecs;
        laphours= lapTime /3600000;
        lapmins=((lapTime %3600000)/60000);
        lapsecs= ((lapTime %3600000)%60000)/1000;
        lapmilisecs=(((lapTime %3600000)%60000)%1000)/100;

        previousMiliseconds=miliseconds;
        if(laphours>0)
            lapTimeText=String.format("%02d%02d:%02d.%01d",laphours,lapmins,lapsecs,lapmilisecs);
        else
            lapTimeText=String.format("%02d:%02d.%01d",lapmins,lapsecs,lapmilisecs);


        mLapsData.add(new Laps(sNo,totaltime,lapTimeText));
        listView.setAdapter(mLapsAdapter);


        }


    public void runTimer(){

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours,mins,secs,milisecs;
                hours= miliseconds /3600000;
                mins=((miliseconds %3600000)/60000);
                secs= ((miliseconds %3600000)%60000)/1000;
                milisecs=(((miliseconds %3600000)%60000)%1000)/100;


                if(hours>0){
                    totaltime=String.format("%02d:%02d:02d.%01d",hours,mins,secs,milisecs);
                }
                else
                    totaltime=String.format("%02d:%02d.%01d",mins,secs,milisecs);

                totalTimer.setText(totaltime);
                if(running){

                    miliseconds+=100;
                }
                handler.postDelayed(this,100);

            }
        });



    }
}
