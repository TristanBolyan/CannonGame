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
    private boolean goBackwards = false;
    private double xCord;
    private double yCord;

    public int interval() {
        return 30;
    }
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(180, 200, 255);
    }
    public void tick(Canvas g) {
        count++;


        xCord = (count*15)%1200;
        yCord = ((count * 15) - (9.8 * ((count) ^ 2))) % 1200;//TODO add funtion to calculate hight

       // if (num < 0) num += 1200;
        Paint redPaint = new Paint();
        redPaint.setColor(Color.BLACK);
        g.drawCircle((int)xCord, (int)yCord, 60, redPaint);

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
            count =0;
        }
    }


}
