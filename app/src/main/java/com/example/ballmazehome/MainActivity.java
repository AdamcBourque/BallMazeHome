package com.example.ballmazehome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static MainActivity INSTANCE;
    Shared_data data = new Shared_data();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INSTANCE = this;
    }

    public void button_click(View view){
        switch (view.getId()){
            case R.id.diffi:
                Intent diffic = new Intent (this, difficulty_selector.class);
                startActivity(diffic);
                break;
            case R.id.high_scores:
                Intent highsc = new Intent (this, high_score.class);
                startActivity(highsc);
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
    public static MainActivity getActivityInstance() {
        return INSTANCE;
    }
    public Shared_data getData(){
        return this.data;
    }
}
