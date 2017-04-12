package com.example.boylan19.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by boylan19 on 4/4/2017.
 */
public class CannonBall {

    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private static double acceleration;
    private static double yWindspeed;
    private static double xWindspeed;

    public CannonBall(double initXposition, double initXvelocity, double initYposition, double initYvelocity) {
        Paint black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);

        this.xPosition = initXposition;
        this.xVelocity = initXvelocity;
        this.yPosition = initYposition;
        this.yVelocity = initYvelocity;
    }

    public double GetXPosition() {
        return xPosition;
    }
    public double GetXVelocity() {
        return xVelocity;
    }
    public double GetYPosition() {
        return yPosition;
    }
    public double GetYVelocity() {
        return yVelocity;
    }

    public void Shot() {
        xVelocity *= -0.2;
        yVelocity *= 0.3;
        if(xVelocity<0) xPosition -= 20;
        else xPosition += 20;
    }

    public void ReDrawCannonBall() {
        xPosition += xVelocity + xWindspeed;
        yVelocity += acceleration;
        yPosition += yVelocity + yWindspeed;
        if(yPosition<0) {
            yPosition=0;
            Ground();
        }
    }

    public void Ground() {
        yVelocity *= -0.2;
        if(xVelocity<1 && xVelocity>=0) xVelocity=1;
        else xVelocity=-1;
    }
}

