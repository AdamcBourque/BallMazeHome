package com.example.ballmazehome;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Skin_shift {

    public Skin_shift(){

    }

    public void skinButton(int skin, Button btn, Context context){
        switch (skin){
            case 0:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skin0_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skin0_btn_text));
                break;
            case 1:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skinSoda_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skinSoda_btn_text));
                break;
            case 2:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skinSunset_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skinSunset_btn_text));
                break;
            case 3:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skinSummer_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skinSummer_btn_text));
                break;
            default:
                break;
        }
    }

    public void skinTextView(int skin, TextView text, Context context){
        switch (skin){
            case 0:
                text.setTextColor(ContextCompat.getColor(context, R.color.skin0_main_text));
                break;
            case 1:
                text.setTextColor(ContextCompat.getColor(context, R.color.skinSoda_main_text));
                break;
            case 2:
                text.setTextColor(ContextCompat.getColor(context, R.color.skinSunset_main_text));
                break;
            case 3:
                text.setTextColor(ContextCompat.getColor(context, R.color.skinSummer_main_text));
                break;
            default:
                break;
        }
    }

    public void skinLayout(int skin, LinearLayout layout, Context context){
        switch (skin){
            case 0:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skin0_background));
                break;
            case 1:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skinSoda_background));
                break;
            case 2:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skinSunset_background));
                break;
            case 3:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skinSummer_background));
                break;
            default:
                break;
        }
    }

    public int getWallColor(int skin, Context context){
        switch (skin){
            case 0:
                return ContextCompat.getColor(context, R.color.skin0_maze_walls);
            case 1:
                return ContextCompat.getColor(context, R.color.skinSoda_maze_walls);
            case 2:
                return ContextCompat.getColor(context, R.color.skinSunset_maze_walls);
            case 3:
                return ContextCompat.getColor(context, R.color.skinSummer_maze_walls);
                default:
                    return 0;
        }
    }
}
