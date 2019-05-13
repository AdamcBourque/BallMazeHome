package com.example.ballmazehome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    Shared_data data = MainActivity.getActivityInstance().getData();
    Button a,s,d,f;
    TextView q;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Skin_shift skinner = new Skin_shift();
        TextView stars = findViewById(R.id.star_count);
        stars.setText("" + data.getStars());
        a = findViewById(R.id.diffi);
        s = findViewById(R.id.high_scores);
        d = findViewById(R.id.skins);
        f = findViewById(R.id.info);
        LinearLayout main2 = findViewById(R.id.linear_layout_home2);
        q = findViewById(R.id.Stars_home);
        skinner.skinButton(data.getSkin(), a, this);
        skinner.skinButton(data.getSkin(), s, this);
        skinner.skinButton(data.getSkin(), d, this);
        skinner.skinButton(data.getSkin(), f, this);
        skinner.skinTextView(data.getSkin(), q, this);
        skinner.skinTextView(data.getSkin(), stars, this);
        skinner.skinLayout(data.getSkin(), main2, this);
    }

    public void button_click(View view){
        switch (view.getId()){
            case R.id.diffi:
                Intent diffic = new Intent (this, difficulty_selector.class);
                startActivity(diffic);
                break;
            case R.id.high_scores:
                Intent highsc = new Intent (this, high_score.class);
                Intent nosc = new Intent (this, no_scores.class);
                if (data.getStars() == 0){
                    startActivity(nosc);
                }else{
                    startActivity(highsc);
                }
                break;
            case R.id.skins:
                Intent skin = new Intent (this, skins.class);
                startActivity(skin);
                break;
            case R.id.info:
                Intent info = new Intent (this, info.class);
                startActivity(info);
                break;
            default:
                break;
        }
    }
}
