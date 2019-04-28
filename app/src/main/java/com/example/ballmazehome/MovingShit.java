package com.example.ballmazehome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.Formatter;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class MovingShit extends View {

    /*This views boundries*/
    private int xMin = 0;
    private int xMax;
    private int yMin = 0;
    private int yMax;

    // Ball's radius
    private float ballRadius = 80;

    private float distance = 15;

    /* Ball's center (x,y) */
    private float ballX = ballRadius + 20;
    private float ballY = ballRadius + 40;

    /* Ball's speed (x,y) */
    private float ballSpeedX = 25;
    private float ballSpeedY = 15;

    // Needed for Canvas.drawOval
    private RectF ballBounds;

    // The paint (e.g. style, color) used for drawing
    private Paint paint;

    // For touch inputs - previous touch (x, y)
    private float previousX;
    private float previousY;

    /* Status message to show Ball's (x,y) position and speed. */
    private StringBuilder statusMsg = new StringBuilder();
    // Formatting the statusMsg
    private Formatter formatter = new Formatter(statusMsg);

    /* Constructor */
    public MovingShit(Context context) {
        super(context);
        ballBounds = new RectF();
        paint = new Paint();

        /* Set the font face and size of drawing text */
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextSize(32);

        // To enable keypad on this View
        this.setFocusable(true);
        this.requestFocus();

        // To enable touch mode
        this.setFocusableInTouchMode(true);

    }

    /* Called back to draw the view. Also called by invalidate() */
    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the ball
        ballBounds.set(ballX-ballRadius, ballY-ballRadius, ballX+ballRadius, ballY+ballRadius);
        paint.setColor(Color.BLUE);
        canvas.drawRect(ballBounds, paint);

        // Update the position of the ball, including collision detection and reaction.
        update();

        // Delay
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {

        }

        // Force a re-draw
        invalidate();

    }

    // Called back when the view is first created or its size changes.
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        xMax = w-1;
        yMax = h-1;
    }

    // Key-up event handler
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT: // Increase rightward speed
                ballX+= distance;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:  // Increase leftward speed
                ballX-= distance;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:    // Increase upward speed
                ballY -= distance;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:  // Increase downward speed
                ballY+= distance;
                break;
            case KeyEvent.KEYCODE_X: // Stop
                ballSpeedX = 0;
                ballSpeedY = 0;
                break;
            case KeyEvent.KEYCODE_A:    // Increase size
                // Max radius is about 90% of half of the smaller dimension
                float maxRadius = (xMax > yMax) ? yMax / 2 * 0.9f  : xMax / 2 * 0.9f;
                if (ballRadius < maxRadius) {
                    ballRadius *= 1.05;   // Increase radius by 5%
                }
                break;
            case KeyEvent.KEYCODE_Z:      // Decrease Size
                if (ballRadius > 20) {    // Minimum radius
                    ballRadius *= 0.95;   // Decrease radius by 5%
                }
                break;
        }
        return true;  // Event handled
    }

    /* Touch-input handler */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        float deltaX, deltaY;
        float scalingFactor = 1000f / ((xMax > yMax) ? yMax : xMax);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // Modify rotational angles according to movement
                deltaX = currentX - previousX;
                deltaY = currentY - previousY;
                ballX += deltaX * scalingFactor;
                ballY += deltaY * scalingFactor;
        }
        // Save current x, y
        previousX = currentX;
        previousY = currentY;
        return true;  // Event handled
    }

    /* Detect collision and update the position of the ball. */
    private void update() {
        // Get new (x,y) position
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Detect collision and react
        if (ballX + ballRadius > xMax) {
            ballSpeedX = -ballSpeedX;
            ballX = xMax-ballRadius;
        } else if (ballX - ballRadius < xMin) {
            ballSpeedX = -ballSpeedX;
            ballX = xMin+ballRadius;
        }

        if (ballY + ballRadius > yMax) {
            ballSpeedY = -ballSpeedY;
            ballY = yMax - ballRadius;
        } else if (ballY - ballRadius < yMin) {
            ballSpeedY = -ballSpeedY;
            ballY = yMin + ballRadius;
        }

        /* Build status message */
        // Empty buffer
        statusMsg.delete(0, statusMsg.length());
        formatter.format("Ball@(%3.0f,%3.0f),Speed=(%2.0f,%2.0f)", ballX, ballY, ballSpeedX, ballSpeedY);


    }



}
