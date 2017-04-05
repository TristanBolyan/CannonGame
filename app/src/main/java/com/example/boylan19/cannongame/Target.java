package com.example.boylan19.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by boylan19 on 4/4/2017.
 */
public class Target implements Animator {
    private int count = 0;
    private boolean goBackwards = true;



    public int interval() {
        return 30;
    }
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(180, 200, 255);
    }
    public void tick(Canvas g) {

        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        g.drawCircle((int)200, 800, 60, redPaint);
        g.drawCircle((int)400, 200, 60, redPaint);

    }


    public boolean doPause() {
        return false;
    }
    public boolean doQuit() {
        return false;
    }

    public void onTouch(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {

        }
    }

}
