package com.example.ballmazehome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_click(View view){
        switch (view.getId()){
            case R.id.diffi:
                break;
            case R.id.high_scores:
                break;
            case R.id.skins:
                break;
            case R.id.info:
                break;
            default:
                break;
        }
    }
}
