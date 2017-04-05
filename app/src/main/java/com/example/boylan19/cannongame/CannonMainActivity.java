package com.example.boylan19.cannongame;

import android.graphics.Point;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * CannonMainActivity
 *
 * This is the activity for the cannon animation. It creates a AnimationCanvas
 * containing a particular Animator object
 *
 * @author Andrew Nuxoll
 * @version September 2012
 *
 */
public class CannonMainActivity extends Activity implement OnSeekBarChangeListener {

    /**
     * creates an AnimationCanvas containing a TestAnimator.
     */
    private TextView Angle;
    private SeekBar AngleBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);
        TextView Angle = (TextView) findViewById(R.id.Angle);
        AngleBar = (SeekBar) findViewById(R.id.AngleBar);
        AngleBar.setOnSeekBarChangeListener(this);

        // Create an animation canvas and place it in the main layout
        Animator testAnim = new CannonBall();
        AnimationCanvas myCanvas = new AnimationCanvas(this, testAnim);
        LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.topLevelLayout);
        mainLayout.addView(myCanvas);

    }
}


