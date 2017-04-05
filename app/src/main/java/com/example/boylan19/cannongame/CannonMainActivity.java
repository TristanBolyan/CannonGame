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
public class CannonMainActivity extends Activity implements View.OnClickListener {

    /**
     * creates an AnimationCanvas containing a TestAnimator.
     */
    private TextView angleT;
    private Button up;
    private Button down;
    public int angle = 45;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);
        TextView angleT = (TextView) findViewById(R.id.Angle);
        Button down = (Button) findViewById(R.id.down);
        Button up = (Button) findViewById(R.id.up);
        up.setOnClickListener(this);
        down.setOnClickListener(this);

        // Create an animation canvas and place it in the main layout
        Animator testAnim = new CannonBall();
        AnimationCanvas myCanvas = new AnimationCanvas(this, testAnim);
        LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.topLevelLayout);
        mainLayout.addView(myCanvas);

    }

    @Override
    public void onClick(View v) {
        if(v == down){
           angleT.setText("Angle:" + (angle--));
        }
        else if(v == up) {
            angleT.setText("Angle:" + (angle++));
        }

    }
}


