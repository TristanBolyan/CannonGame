package com.example.boylan19.cannongame;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.*;
import android.os.Build;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by boylan19 on 4/4/2017.
 *
 *
 * implemented a basic of homework 3 that works (as opposed to my original failled attempt)
 *
 * -implemented moving targets (8points)
 * -implemented many balls(10points)
 * -ball roles allong hte ground (10 points)
 *
 */
public class Cannon implements Animator {
    private int num;
    private int numShot;
    private ArrayList<CannonBall> balls;
    private double cannonXposition;
    private double cannonYposition;
    private double target1Xposition;
    private double target1Yposition;
    private double target2Xposition;
    private double target2Yposition;
    private int xSize;
    private int ySize;
    private Paint red;
    private Paint black;
    private Paint blue;
    private Path path;

    public Cannon(CannonMainActivity activity) {
        balls = new ArrayList<>();
        path = new Path();
        red = new Paint();
        red.setColor(Color.RED);
        red.setStyle(Paint.Style.FILL);
        black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);
        black.setTextSize(40);
        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);

        num = 0;
        numShot = 0;
        cannonXposition =  (1 / Math.sqrt(2));
        cannonYposition =  (1 / Math.sqrt(2));

    }

    public int interval() {
        return 30;
    }
    public int backgroundColor() {return Color.rgb(180, 200, 255);}
    public void tick(Canvas g) {
        num++;
        xSize = g.getWidth();
        ySize = g.getHeight();

        target1Xposition = 0.6f * xSize;
        target2Xposition = 0.8f * xSize;
        target1Yposition = 0.1f * ySize + 0.2f * ySize * (float) Math.sin(2 * Math.toRadians(num));
        target2Yposition = 0.2f * ySize + 0.2f * ySize * (float) Math.sin(3 * Math.toRadians(num));

        g.drawOval((float) target1Xposition - 100, (float) (ySize - target1Yposition - 100), (float) target1Xposition + 100, (float) (ySize - target1Yposition + 100), blue);
        g.drawOval((float) target2Xposition - 100, (float) (ySize - target2Yposition - 100),(float) target2Xposition + 100,(float) (ySize - target2Yposition + 100), blue);

        for (int i = 0; i < balls.size(); i++) {
            CannonBall ball = balls.get(i);
            if (ball == null) { continue; }
            double ballXPos = ball.GetXPosition();
            double ballYPos = ball.GetYPosition();
            if (ballXPos < -40 || ballXPos > xSize) {
                balls.remove(i);
                i--;
                continue;
            } else if (target1Xposition - 35 < ballXPos && ballXPos < target1Xposition + 15 && target1Yposition - 120 < ballYPos && ballYPos < target1Yposition + 80) {
                ball.Shot();
                g.drawPaint(red);
                g.drawCircle((float)target1Xposition, (float)target1Yposition, 500, red);
                numShot++;
            } else if (target2Xposition - 35 < ballXPos && ballXPos < target2Xposition + 15 && target2Yposition - 120 < ballYPos && ballYPos < target2Yposition + 80) {
                ball.Shot();
                g.drawPaint(red);
                g.drawCircle((float)target2Xposition, (float)target2Yposition, 500, red);
                numShot++;
            }
            g.drawCircle((float)ballXPos + 20, (float)ySize - (float)ballYPos - 100, 20, black);
            ball.ReDrawCannonBall();
        }

        g.drawArc(10, ySize - 140, 180, ySize - 60, 0, -180, true, black);
        path.reset();
        path.moveTo(140 - 40 * (float)cannonYposition, (float)ySize - 100 - 40 * (float)cannonXposition);
        path.rLineTo(100 * (float)cannonXposition, -100 * (float)cannonYposition);
        path.rLineTo(40 * (float)cannonYposition, 40 *(float) cannonXposition);
        path.rLineTo(-100 * (float)cannonXposition, 100 * (float)cannonYposition);
        path.close();
        g.drawPath(path, black);

        g.drawText("Score: " + numShot, 30, 50, black);

    }

    public boolean doPause() { return false; }
    public boolean doQuit() {
        return false;
    }

    public void onTouch(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            cannonXposition = event.getX() - 120 - 20 * cannonYposition;
            cannonYposition = ySize - event.getY();
            double mag = Math.sqrt(cannonXposition * cannonXposition + cannonYposition * cannonYposition);
            cannonXposition /= mag;
            cannonYposition /= mag;
            balls.add(new CannonBall(100 * cannonYposition + 100 * cannonXposition, 80 + 20 * cannonXposition + 100 * cannonYposition, 50 * cannonXposition, 50 * cannonYposition));
        }
    }



}
