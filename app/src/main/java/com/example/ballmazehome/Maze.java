package com.example.ballmazehome;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Maze extends AppCompatActivity implements SensorEventListener {

    private Sensor accelerometer;
    private SensorManager sensorManager;
    private int currentSensor;
    private long lastUpdate = 0;
    private float ballX, ballY;
    private ImageView ball;
    private FrameLayout maze;
    int xMax = Resources.getSystem().getDisplayMetrics().widthPixels;
    int yMax = Resources.getSystem().getDisplayMetrics().heightPixels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ball = findViewById(R.id.ball);
        currentSensor = Sensor.TYPE_ACCELEROMETER;
        maze = findViewById(R.id.maze);
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
                float z = event.values[2];
                long curTime = System.currentTimeMillis();

                if ((curTime - lastUpdate) > 10) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    float speedX = x / Math.abs(diffTime) * 1000; // divided by 10
                    float speedY = y / Math.abs(diffTime) * 1000;


                    if (ballX < 0 || ballX > xMax){
                        ballX = ballX + 2*speedX;
                    }else{
                        ballX = ballX - speedX;
                    }
                    if (ballY < 0 || ballY > yMax){
                        ballY = ballY + 2*speedY;
                    }else{
                        ballY = ballY - speedY;
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


