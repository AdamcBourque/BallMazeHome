package com.example.ballmazehome;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Win_screen extends AppCompatActivity {


    MediaController media;
    long times;
    Shared_data data = MainActivity.getActivityInstance().getData();
    Skin_shift skinner = new Skin_shift();
    TextView star, a,s,time2;
    Button q;
    LinearLayout main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
        TextView stars = findViewById(R.id.star_count);
        stars.setText("" + data.getStars());
        a = findViewById(R.id.grats);
        s = findViewById(R.id.time_text);
        time2 = findViewById(R.id.time);
        star = findViewById(R.id.Stars_win);
        main = findViewById(R.id.linear_layout_win);
        q = findViewById(R.id.back_to_score_button);
        skinner.skinTextView(data.getSkin(), a, this);
        skinner.skinTextView(data.getSkin(), s, this);
        skinner.skinTextView(data.getSkin(), star, this);
        skinner.skinTextView(data.getSkin(), time2, this);
        skinner.skinButton(data.getSkin(), q, this);
        skinner.skinTextView(data.getSkin(), stars, this);
        skinner.skinLayout(data.getSkin(), main, this);

        times = Maze.getActivityInstance().getData();
        String output = data.toString(times);
        time2.setText(output);
        if (times/1000 > 120){
            a.setText("You disappoint me");
        }

        VideoView rick = findViewById(R.id.rick);
        media =  new MediaController(this);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.rick;

        Uri uri = Uri.parse(path);
        rick.setMediaController(media);
        media.setAnchorView(rick);
        rick.setVideoURI(uri);
        rick.start();

    }

    public void button_click(View view){
        Intent high_score = new Intent (this, high_score.class);
        startActivity(high_score);
    }
}
