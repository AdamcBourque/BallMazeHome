package com.example.ballmazehome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class high_score extends AppCompatActivity {

    Shared_data data = MainActivity.getActivityInstance().getData();
    long times, teasy = data.getTime_easy(), tnormal = data.getTime_normal(), thard = data.getTime_hard(), time, secs, mins;
    int difficulty;
    String output;
    String pr[] = new String[3];
    TextView easy, normal, hard;


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

        Toast.makeText(this, data.toString(data.getTime_easy()), Toast.LENGTH_LONG).show();
        //Toast.makeText(this, data.toString(data.getTime_normal()), Toast.LENGTH_LONG).show();
        //Toast.makeText(this, data.toString(data.getTime_hard()), Toast.LENGTH_LONG).show();

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
