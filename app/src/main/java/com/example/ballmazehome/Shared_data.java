package com.example.ballmazehome;

public class Shared_data {

    private long time_easy, time_normal, time_hard;
    private int stars, skin, diffi;

    public Shared_data(){

    }
    public int getStars(){
        return stars;
    }
    public int getSkin(){
        return skin;
    }
    public int getDiffi(){
        return diffi;
    }
    public long getTime_easy(){
        return time_easy;
    }
    public long getTime_normal(){
        return time_normal;
    }
    public long getTime_hard(){
        return time_hard;
    }
    public void setDiffi(int dif){
        diffi = dif;
    }
    public void setTime_easy(long time){
        time_easy = time;
    }
    public void setTime_normal(long time){
        time_normal = time;
    }
    public void setTime_hard(long time){
        time_hard = time;
    }
    public void setSkin(int skinv){
        skin = skinv;
    }
    public void setStars(int star){
        stars = star;
    }
    public String toString(long time){
        long t_secs = (int)(time/1000);
        long secs = t_secs % 60;
        long mins = t_secs / 60;
        String seconds = Long.toString(secs);
        String minutes = Long.toString(mins);
        String output = minutes + ":" + seconds;
        return output;
    }
}
