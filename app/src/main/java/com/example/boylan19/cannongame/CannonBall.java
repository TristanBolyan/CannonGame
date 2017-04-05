package com.example.boylan19.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by boylan19 on 4/4/2017.
 */
public class CannonBall implements Animator {
    private int count = 0;
    private double para = 0.1;
    private boolean goBackwards = true;
    private double xCord;
    private double yCord;
    int angle = 45;

    public int interval() {
        return 30;
    }
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(180, 200, 255);
    }
    public void tick(Canvas g) {
        count++;
        para = para *1.025;

        xCord = ((count*15)*Math.cos(angle));
        yCord = ((count * 15) - (para * ((count*15) ^ 2)));//TODO add funtion to calculate hight

       // if (num < 0) num += 1200;
        Paint redPaint = new Paint();
        redPaint.setColor(Color.BLACK);
        g.drawCircle((int)yCord, (int)xCord, 60, redPaint);

    }


    public boolean doPause() {
        if (goBackwards)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean doQuit() {
        return false;
    }

    public void onTouch(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            goBackwards = !goBackwards;
            count =3;
            para = 0.1;
        }
    }


}
