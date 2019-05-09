package com.example.ballmazehome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;




public class Maze extends AppCompatActivity implements SensorEventListener {

    private long  startTime, stopTime, totalTime;
    private Sensor accelerometer;
    private SensorManager sensorManager;
    private int currentSensor, num_walls, difficulty;
    private long lastUpdate = 0;
    private float ballX = 30, ballY = 30;
    private ImageView ball_image, goal_image;
    private Rect ball, goal, walls[];
    private ImageView wall_images[];
    private FrameLayout maze;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        maze = findViewById(R.id.maze);
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
        difficulty = getIntent().getIntExtra("check", 0);
        switch (difficulty){
            case 0:
                num_walls = 10;
                walls = new Rect[num_walls];
                for (int i = 0; i < num_walls; i++){
                    walls[i] = new Rect();
                }
                ballX = ball.left;
                ballY = ball.top;
                walls[0].set(150, 150, 190, 300);
                walls[1].set(150, 300, 400, 340);
                walls[2].set(360, 340, 400, 640);
                walls[3].set(150, 540, 190, 840);
                walls[4].set(360, 640, deviceWidth / 5, 680);
                walls[5].set(0, 840, 190, 880);
                walls[6].set(360, 840, 400, deviceHeight / 10);
                walls[7].set(150, 150, deviceWidth / 5 - 200, 190);
                walls[8].set(deviceWidth / 5, 0, deviceWidth / 5 + 40, deviceHeight / 10);
                walls[9].set(0, deviceHeight / 11 - 30, deviceWidth / 5 , deviceHeight / 11 + 10);

                wall_images = new ImageView[num_walls];

                for (int i = 0; i < num_walls; i++){
                    wall_images[i] = new ImageView(getApplicationContext());
                    maze.addView(wall_images[i]);
                    wall_images[i].setX(walls[i].left);
                    wall_images[i].setY(walls[i].top);
                    wall_images[i].getLayoutParams().height = walls[i].bottom - walls[i].top;
                    wall_images[i].getLayoutParams().width = walls[i].right - walls[i].left;
                    wall_images[i].setBackgroundColor(Color.BLACK);
                    wall_images[i].setVisibility(View.VISIBLE);
                }
                break;
            case 1:
                num_walls = 11;
                walls = new Rect[num_walls];
                for (int i = 0; i < num_walls; i++){
                    walls[i] = new Rect();
                }
                ballX = ball.left;
                ballY = ball.top;
                walls[0].set(300, 150, 340, 400);
                walls[1].set(0, 150, 300, 190);
                walls[2].set(300, 550, deviceWidth / 5, 590);
                walls[3].set(150, 540, 190, 840);
                walls[4].set(300, 550, 340, 880);
                walls[5].set(150, 840, 300, 880);
                walls[6].set(470, 780, 510, deviceHeight / 10);
                walls[7].set(300, 360, 490, 400);
                walls[8].set(490, 150, 530, 400);

                walls[9].set(deviceWidth / 5, 0, deviceWidth / 5 + 40, deviceHeight / 10);
                walls[10].set(0, deviceHeight / 11 - 30, deviceWidth / 5 , deviceHeight / 11 + 10);

                wall_images = new ImageView[num_walls];

                for (int i = 0; i < num_walls; i++){
                    wall_images[i] = new ImageView(getApplicationContext());
                    maze.addView(wall_images[i]);
                    wall_images[i].setX(walls[i].left);
                    wall_images[i].setY(walls[i].top);
                    wall_images[i].getLayoutParams().height = walls[i].bottom - walls[i].top;
                    wall_images[i].getLayoutParams().width = walls[i].right - walls[i].left;
                    wall_images[i].setBackgroundColor(Color.BLACK);
                    wall_images[i].setVisibility(View.VISIBLE);
                }
                break;
            case 2:
                num_walls = 11;
                walls = new Rect[num_walls];
                for (int i = 0; i < num_walls; i++){
                    walls[i] = new Rect();
                }
                ballX = ball.left;
                ballY = ball.top;
                walls[0].set(300, 150, 340, 400);
                walls[1].set(0, 150, 300, 190);
                walls[2].set(300, 550, deviceWidth / 5, 590);
                walls[3].set(150, 540, 190, 840);
                walls[4].set(300, 550, 340, 880);
                walls[5].set(150, 840, 300, 880);
                walls[6].set(470, 780, 510, deviceHeight / 10);
                walls[7].set(300, 360, 490, 400);
                walls[8].set(490, 150, 530, 400);

                walls[9].set(deviceWidth / 5, 0, deviceWidth / 5 + 40, deviceHeight / 10);
                walls[10].set(0, deviceHeight / 11 - 30, deviceWidth / 5 , deviceHeight / 11 + 10);

                break;
            default:
                Toast.makeText(this,"An Error Occurred. Please Try Again.", Toast.LENGTH_LONG).show();
                break;
        }


        goal.set((int)(xMax - 40), (int)(yMax - 40), (int)xMax, (int)yMax);
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
                int deviceWidth = displayMetrics.widthPixels;
                int deviceHeight = displayMetrics.heightPixels;
                long curTime = System.currentTimeMillis();

                if ((curTime - lastUpdate) > 0) {
                    lastUpdate = curTime;

                    float speedX = 2 * x ; // divided by 10
                    float speedY = 2 * y ;

                    if (ballX < 0 ){
                        ballX = 20;
                    } else{
                        ballX = ballX - speedX;
                    }
                    if (ballY < 0 ){
                        ballY = 20;
                    }else{
                        ballY = ballY + speedY;
                    }
                    ball_image.setX(ballX);
                    ball_image.setY(ballY);
                    ball.offsetTo((int)ballX, (int)ballY);
                    if (difficulty == 0){
                        if (collides(walls[0]) || collides(walls[1]) || collides(walls[2]) || collides(walls[3]) || collides(walls[4]) || collides(walls[5])
                                || collides(walls[6]) || collides(walls[7]) || collides(walls[8]) || collides(walls[9])) {
                            //float temp =  (float)(Math.sin(90 - Math.asin((speedY / Math.sqrt((speedY * speedY + speedX * speedX))))) * (speedY * speedY + speedX * speedX));
                            ballY = ballY - 2 * speedY;
                            ballX = ballX + 2 * speedX;
                        }
                    }else {
                        if (collides(walls[0]) || collides(walls[1]) || collides(walls[2]) || collides(walls[3]) || collides(walls[4]) || collides(walls[5])
                                || collides(walls[6]) || collides(walls[7]) || collides(walls[8]) || collides(walls[9]) || collides(walls[10])) {
                            //float temp =  (float)(Math.sin(90 - Math.asin((speedY / Math.sqrt((speedY * speedY + speedX * speedX))))) * (speedY * speedY + speedX * speedX));
                            ballY = ballY - 2 * speedY;
                            ballX = ballX + 2 * speedX;
                        }
                    }
                    if (collides(goal)){
                        Toast.makeText(this, "WRYYYYY!!", Toast.LENGTH_LONG).show();
                        stopTime = SystemClock.uptimeMillis();
                        totalTime = stopTime - startTime;
                        finish();
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


