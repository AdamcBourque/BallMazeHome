package com.example.ballmazehome;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;

public class Maze extends AppCompatActivity implements SensorEventListener {

    private Sensor accelerometer;
    private SensorManager sensorManager;
    private int currentSensor;
    private long lastUpdate = 0;
    private float ballX = 30, ballY = 30;
    private ImageView ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ball = findViewById(R.id.ball);
        currentSensor = Sensor.TYPE_ACCELEROMETER;
        ballX = ball.getX();
        ballY = ball.getY();
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
                int deviceWidth = displayMetrics.widthPixels;
                int deviceHeight = displayMetrics.heightPixels;
                float xMax = deviceWidth - 160;
                float yMax = deviceHeight - 320;
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
                    ball.setX(ballX);
                    ball.setY(ballY);
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

}


