package com.example.ballmazehome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class high_score extends AppCompatActivity {

    TextView easy, normal, hard;
    Shared_data data = new Shared_data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        easy = findViewById(R.id.hi);
        normal = findViewById(R.id.hi2);
        hard = findViewById(R.id.hi3);
        easy.setText(data.toString(data.getTime_easy()));
        normal.setText(data.toString(data.getTime_normal()));
        hard.setText(data.toString(data.getTime_hard()));
    }

}
