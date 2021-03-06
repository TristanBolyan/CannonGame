package com.example.boylan19.cannongame;

import android.graphics.Point;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

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
public class CannonMainActivity extends Activity  {

    /**
     * creates an AnimationCanvas containing a TestAnimator.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);

        // Create an animation canvas and place it in the main layout
        Animator testAnim = new Cannon(this);
        AnimationCanvas myCanvas = new AnimationCanvas(this, testAnim);
        LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.topLevelLayout);
        mainLayout.addView(myCanvas);

    }
}


