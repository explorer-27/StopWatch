package com.example.ashu.stopwatch;

/**
 * Created by ashu on 17/1/18.
 */

public class Laps {
        private int sNo=0;
        private String totalTime;
        private String lapTimeText;

    public Laps(int sNo, String totalTime, String lapTimeText) {
        this.sNo = sNo;
        this.totalTime = totalTime;
        this.lapTimeText = lapTimeText;
    }

    public int getsNo() {
        return sNo;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public String getLapTimeText() {
        return lapTimeText;
    }
}
