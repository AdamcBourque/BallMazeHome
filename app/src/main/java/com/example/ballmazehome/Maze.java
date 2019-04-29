package com.example.ballmazehome;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class Maze extends AppCompatActivity implements SensorEventListener {

    private Sensor accelerometer;
    private SensorManager sensorManager;
    private int currentSensor;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private ImageView ball;
    private FrameLayout maze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ball = findViewById(R.id.ball);
        currentSensor = Sensor.TYPE_ACCELEROMETER;
        maze = findViewById(R.id.maze);
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

                if ((curTime - lastUpdate) > 100) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 1000; // divided by 10

                    last_x = x;
                    last_y = y;
                    last_z = z;
                    // if else to test boarders
                    if (0 < ball.getLeft() && ball.getLeft() < maze.getLeft() && 0 < ball.getTop() && ball.getTop() < maze.getTop()){
                        ball.setLeft((ball.getLeft() + (int)speed));
                        ball.setTop((ball.getTop() + (int)speed));
                    }else{
                        ball.setLeft((ball.getLeft() - (int)speed));
                        ball.setTop((ball.getTop() - (int)speed));
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

}


