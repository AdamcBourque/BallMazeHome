package com.example.ballmazehome;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Win_screen extends AppCompatActivity {

    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
        ImageView rick = findViewById(R.id.rick);

        //rick.setImageResource();
        //TextView time = findViewById(R.id.time);
        //time.setText(num);
    }
    public void button_click(View view){
        Intent high_score = new Intent (this, high_score.class);
        startActivity(high_score);
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if(resultCode == RESULT_OK){
                int listPos = data.getIntExtra("listPosition", 1);
                //edit listview value at position
                num = data.getIntExtra("check", num);
            }
        }
    }
    */
}
