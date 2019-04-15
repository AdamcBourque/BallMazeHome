package com.example.ballmazehome;

import java.util.*;

public class MazeGenerator {

    private int difficulty;

    public MazeGenerator(int width, int height){

    }

    public void displayMaze(MazeGenerator maze){

    }

    public boolean setDifficulty(int dif){
        if (dif < 3) {
            difficulty = dif;
            return true;
        }else{
            return false;
        }
    }


}
