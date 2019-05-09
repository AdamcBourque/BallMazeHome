package com.example.ballmazehome;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Win_screen extends AppCompatActivity {

    private int num;
    MediaController media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
        VideoView rick = findViewById(R.id.rick);
        media =  new MediaController(this);
        String path = "android.resource://" + getPackageName() + "bruh_video.mp4";
        Uri uri = Uri.parse(path);
        rick.setMediaController(media);
        media.setAnchorView(rick);
        rick.setVideoURI(uri);
        rick.start();

        String time_string = getIntent().getStringExtra("check");
        TextView time = findViewById(R.id.time);
        time.setText(time_string);


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
