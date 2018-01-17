package com.example.ashu.stopwatch;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashu on 17/1/18.
 */

public class LapsAdapter extends ArrayAdapter<Laps> {


    public LapsAdapter(Activity context,ArrayList<Laps> word){
        super(context,0, (List<Laps>) word);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.single_item,parent,false);
        }
        Laps currentWord=getItem(position);

        TextView tvLapTimeText =(TextView)listItemView.findViewById(R.id.lapTimeText);
        tvLapTimeText.setText(currentWord.getLapTimeText());
        TextView tvTotalTime=(TextView)listItemView.findViewById(R.id.totaltime);
        tvTotalTime.setText(currentWord.getTotalTime());
        TextView tvSNo =(TextView)listItemView.findViewById(R.id.sNo);
        tvSNo.setText(""+currentWord.getsNo());
        return listItemView;
    }


}
