package com.example.ballmazehome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class difficulty_selector extends AppCompatActivity {

    private int diffi = 0;
    Shared_data data = MainActivity.getActivityInstance().getData();
    Skin_shift skinner = new Skin_shift();
    Button a,s,d;
    LinearLayout main;
    TextView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selector);
        TextView stars = findViewById(R.id.star_count);
        stars.setText("" + data.getStars());
        a = findViewById(R.id.pleb);
        s = findViewById(R.id.norm);
        d = findViewById(R.id.hard);
        main = findViewById(R.id.linear_layout_diff);
        star = findViewById(R.id.stars_diff);
        skinner.skinButton(data.getSkin(), a, this);
        skinner.skinButton(data.getSkin(), s, this);
        skinner.skinButton(data.getSkin(), d, this);
        skinner.skinTextView(data.getSkin(), star, this);
        skinner.skinTextView(data.getSkin(), stars, this);
        skinner.skinLayout(data.getSkin(), main, this);
    }
    public void button_click(View view){
        Intent maze;
        Intent cancer = new Intent (this, Win_screen.class);
        switch (view.getId()){
            case R.id.pleb:
                diffi = 0;
                maze = new Intent(getBaseContext(), Maze.class);
                maze.putExtra("check", diffi);
                startActivity(cancer);
                startActivity(maze);
                break;
            case R.id.norm:
                diffi = 1;
                maze = new Intent(getBaseContext(), Maze.class);
                maze.putExtra("check", diffi);
                startActivity(cancer);
                startActivity(maze);
                break;
            case R.id.hard:
                diffi = 2;
                maze = new Intent(getBaseContext(), Maze.class);
                maze.putExtra("check", diffi);
                startActivity(cancer);
                startActivity(maze);
                break;
            default:
                break;
        }
    }

}
