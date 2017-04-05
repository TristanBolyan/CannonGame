package com.example.boylan19.cannongame;

import android.graphics.*;
import android.os.Build;
import android.view.MotionEvent;

/**
 * Created by boylan19 on 4/4/2017.
 */
public class Cannon implements Animator {
    private int count = 0;
    private boolean goBackwards = false;
    public int bottom;
    public int top;
    public int right;
    public int left;
    public int interval() {
        return 30;
    }
    public int backgroundColor() {
        // create/return the background color
        return Color.rgb(180, 200, 255);
    }
    public void tick(Canvas g) {
        if (goBackwards) {
            count--;
        }
        else {
            count++;
        }


        int num = 0;
        Paint redPaint = new Paint();
        redPaint.setColor(Color.GRAY);
        g.drawCircle(0, 0, 100, redPaint);

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
            goBackwards = !goBackwards;
        }
    }

}
