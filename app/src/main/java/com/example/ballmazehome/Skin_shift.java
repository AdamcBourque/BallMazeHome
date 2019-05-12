package com.example.ballmazehome;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Skin_shift {

    public void skinButton(int skin, Button btn, Context context){
        switch (skin){
            case 0:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skin1_btn_text));
                break;
            case 1:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skin1_btn_text));
                break;
            case 2:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skin1_btn_text));
                break;
            case 3:
                btn.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_buttons));
                btn.setTextColor(ContextCompat.getColor(context, R.color.skin1_btn_text));
                break;
            default:
                break;
        }
    }

    public void skinTextView(int skin, TextView text, Context context){
        switch (skin){
            case 0:
                text.setTextColor(ContextCompat.getColor(context, R.color.skin1_main_text));
                break;
            case 1:
                text.setTextColor(ContextCompat.getColor(context, R.color.skin1_main_text));
                break;
            case 2:
                text.setTextColor(ContextCompat.getColor(context, R.color.skin1_main_text));
                break;
            case 3:
                text.setTextColor(ContextCompat.getColor(context, R.color.skin1_main_text));
                break;
            default:
                break;
        }
    }

    public void skinLayout(int skin, LinearLayout layout, Context context){
        switch (skin){
            case 0:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_background));
                break;
            case 1:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_background));
                break;
            case 2:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_background));
                break;
            case 3:
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.skin1_background));
                break;
            default:
                break;
        }
    }

    public void skinMaze(int skin){

    }
}
