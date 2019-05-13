package com.example.ballmazehome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class skins extends AppCompatActivity {

    Shared_data data = MainActivity.getActivityInstance().getData();
    Skin_shift skinner = new Skin_shift();
    TextView q,w,e,r,t;
    Button a,s,d,f;
    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skins);
        TextView stars = findViewById(R.id.star_count);
        stars.setText("" + data.getStars());
        main = findViewById(R.id.linear_layout_skins);
        q = findViewById(R.id.skin_name);
        w = findViewById(R.id.skin_name2);
        e = findViewById(R.id.skin_name3);
        r = findViewById(R.id.skin_name4);
        t = findViewById(R.id.Stars_skins);
        a = findViewById(R.id.skin_default);
        s = findViewById(R.id.skin_peculiar_soda);
        d = findViewById(R.id.skin_three);
        f = findViewById(R.id.skin_four);
        update();
        s.setClickable(false);
        d.setClickable(false);
        f.setClickable(false);
        if (data.getStars() >= 6){
            s.setClickable(true);
        }
        if (data.getStars() >= 3){
            d.setClickable(true);
        }
        if (data.getStars() > 0){
            f.setClickable(true);
        }

    }

    public void onClick(View view){
        if (view.getId() == a.getId()){
            data.setSkin(0);
            update();
        }else if(view.getId() == s.getId()){
            data.setSkin(1);
            update();
        }else if(view.getId() == d.getId()){
            data.setSkin(2);
            update();
        }else if(view.getId() == f.getId()){
            data.setSkin(3);
            update();
        }
    }
    public void update(){
        skinner.skinTextView(data.getSkin(),q,this);
        skinner.skinTextView(data.getSkin(),w,this);
        skinner.skinTextView(data.getSkin(),e,this);
        skinner.skinTextView(data.getSkin(),r,this);
        skinner.skinTextView(data.getSkin(),t,this);
        skinner.skinButton(data.getSkin(),a,this);
        skinner.skinButton(data.getSkin(),s,this);
        skinner.skinButton(data.getSkin(),d,this);
        skinner.skinButton(data.getSkin(),f,this);
        skinner.skinLayout(data.getSkin(),main, this);
    }
}

