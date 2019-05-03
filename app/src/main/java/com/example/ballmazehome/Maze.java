package com.example.ballmazehome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;




public class Maze extends AppCompatActivity implements SensorEventListener {

    private long  startTime, stopTime, totalTime;
    private Sensor accelerometer;
    private SensorManager sensorManager;
    private int currentSensor;
    private long lastUpdate = 0;
    private float ballX = 30, ballY = 30;
    private ImageView ball_image, goal_image;
    private Rect ball, goal;
    Intent test = new Intent (this, high_score.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ball_image = findViewById(R.id.ball);
        goal_image = findViewById(R.id.goal);
        currentSensor = Sensor.TYPE_ACCELEROMETER;
        startTime = SystemClock.uptimeMillis();
        // ballX = ball.getX();
      //  ballY = ball.getY();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = 5 * displayMetrics.widthPixels;
        int deviceHeight = 10 * displayMetrics.heightPixels;
        float xMax = deviceWidth / 6;
        float yMax = deviceHeight / 13;
        goal = new Rect();
        ball = new Rect();
        ballX = ball.left;
        ballY = ball.top;
        goal.set((int)(xMax - 80), (int)(yMax - 80), (int)xMax, (int)yMax);
        ball.set((int)ballX, (int)ballY, (int)(ballX+80), (int)(ballY+80));
        goal_image.setX(xMax - 80);
        goal_image.setY(yMax - 80);
    }

    public boolean checkSensorAvailability(int sensorType) {
        boolean isSensor = false;
        if (sensorManager.getDefaultSensor(sensorType) != null) {
            isSensor = true;
        }
        return isSensor;
    }

    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == currentSensor) {
            if (currentSensor == Sensor.TYPE_ACCELEROMETER) {
                float x = event.values[0];
                float y = event.values[1];
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
                int deviceWidth = 5 * displayMetrics.widthPixels;
                int deviceHeight = 10 * displayMetrics.heightPixels;
                float xMax = deviceWidth / 6;
                float yMax = deviceHeight / 13;
                long curTime = System.currentTimeMillis();

                if ((curTime - lastUpdate) > 0.00001) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    float speedX = x / Math.abs(diffTime) * 1000; // divided by 10
                    float speedY = y / Math.abs(diffTime) * 1000;

                    if (ballX < 0 ){
                        ballX = 20;
                    }else if (ballX > xMax) {
                        ballX = xMax - 20;
                    }else{
                        ballX = ballX - speedX;
                    }
                    if (ballY < 0 ){
                        ballY = 20;
                    }else if (ballY > yMax) {
                        ballY = yMax - 20;
                    }else{
                        ballY = ballY + speedY;
                    }
                    ball_image.setX(ballX);
                    ball_image.setY(ballY);
                    ball.offsetTo((int)ballX, (int)ballY);
                    if (collides(goal)){
                        stopTime = SystemClock.uptimeMillis();
                        totalTime = stopTime - startTime;
                        startActivity(test);
                    }
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public boolean collides(Rect wall){
        if (Rect.intersects(ball, wall)){
            return true;
        }else{
            return false;
        }
    }

}


