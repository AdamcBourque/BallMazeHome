package com.example.ballmazehome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class high_score extends AppCompatActivity {

    long times, teasy = 200000000, tnormal = 200000000, thard = 200000000, time, secs, mins;
    int difficulty;
    String seconds, minutes, output;
    String pr[] = new String[3];
    TextView easy, normal, hard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        easy = findViewById(R.id.hi);
        normal = findViewById(R.id.hi2);
        hard = findViewById(R.id.hi3);
        times = Maze.getActivityInstance().getData();
        time = (int)(times/1000);
        secs = time % 60;
        mins = time / 60;
        seconds = Long.toString(secs);
        minutes = Long.toString(mins);
        output = minutes + ":" + seconds;

        difficulty = Maze.getActivityInstance().getDifficulty();

        time = (int)(teasy/1000);
        secs = time % 60;
        mins = time / 60;
        seconds = Long.toString(secs);
        minutes = Long.toString(mins);
        pr[0] = minutes + ":" + seconds;
        time = (int)(tnormal/1000);
        secs = time % 60;
        mins = time / 60;
        seconds = Long.toString(secs);
        minutes = Long.toString(mins);
        pr[1] = minutes + ":" + seconds;
        time = (int)(thard/1000);
        secs = time % 60;
        mins = time / 60;
        seconds = Long.toString(secs);
        minutes = Long.toString(mins);
        pr[2] = minutes + ":" + seconds;

        switch (difficulty){
            case 0:
                if (times < teasy){
                    teasy = times;
                    easy.setText(output);
                    normal.setText(pr[1]);
                    hard.setText(pr[2]);
                }else{
                    easy.setText(pr[0]);
                    normal.setText(pr[1]);
                    hard.setText(pr[2]);
                }
                break;
            case 1:
                if (times < tnormal){
                    tnormal = times;
                    normal.setText(output);
                    hard.setText(pr[2]);
                    easy.setText(pr[0]);
                }else{
                    normal.setText(pr[1]);
                    normal.setText(pr[1]);
                    hard.setText(pr[2]);
                }
                break;
            case 2:
                if (times < thard){
                    thard = times;
                    hard.setText(output);
                    normal.setText(pr[1]);
                    easy.setText(pr[0]);
                }else{
                    hard.setText(pr[2]);
                    normal.setText(pr[1]);
                    hard.setText(pr[2]);
                }
                break;
            default:
                break;
        }
    }
}
