package com.example.ballmazehome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class difficulty_selector extends AppCompatActivity {

    private int diffi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selector);
    }
    public void button_click(View view){
        Intent maze = new Intent (this, Maze.class);
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
