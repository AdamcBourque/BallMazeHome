package com.example.ballmazehome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class high_score extends AppCompatActivity {

    Shared_data data = MainActivity.getActivityInstance().getData();
    long times, teasy = data.getTime_easy(), tnormal = data.getTime_normal(), thard = data.getTime_hard(), time, secs, mins;
    int difficulty;
    String output;
    String pr[] = new String[3];
    TextView easy, normal, hard;
    Skin_shift skinner = new Skin_shift();
    TextView star, a,s,d;
    LinearLayout main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        TextView stars = findViewById(R.id.star_count);
        stars.setText("" + data.getStars());
        easy = findViewById(R.id.hi);
        normal = findViewById(R.id.hi2);
        hard = findViewById(R.id.hi3);
        times = Maze.getActivityInstance().getData();
        teasy = data.getTime_easy();
        tnormal = data.getTime_normal();
        thard = data.getTime_hard();
        output = data.toString(times);
        a = findViewById(R.id.plebian_hscore);
        s = findViewById(R.id.normie_hscore);
        d = findViewById(R.id.hard_UwU_hscore);
        star = findViewById(R.id.Stars_hscore);
        main = findViewById(R.id.linear_layout_hscore);

        skinner.skinTextView(data.getSkin(), a, this);
        skinner.skinTextView(data.getSkin(), s, this);
        skinner.skinTextView(data.getSkin(), star, this);
        skinner.skinTextView(data.getSkin(), d, this);
        skinner.skinTextView(data.getSkin(), stars, this);
        skinner.skinTextView(data.getSkin(), easy, this);
        skinner.skinTextView(data.getSkin(), normal, this);
        skinner.skinTextView(data.getSkin(), hard, this);
        skinner.skinLayout(data.getSkin(), main, this);


        difficulty = Maze.getActivityInstance().getDifficulty();

        if (teasy == 0 && difficulty == 0){
            teasy = times;
        }
        if (tnormal == 0 && difficulty == 1){
            tnormal = times;
        }
        if (thard == 0 && difficulty == 2){
            thard = times;
        }

        pr[0] = data.toString(teasy);
        pr[1] = data.toString(tnormal);
        pr[2] = data.toString(thard);


        switch (difficulty){
            case 0:
                if (times <= teasy){
                    data.setTime_easy(times);
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
                if (times <= tnormal){
                    data.setTime_normal(times);
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
                if (times <= thard){
                    data.setTime_hard(times);
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
