package abroscreative.com.animationdemo;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.PathMotion;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
    }

    public void slideTransition(View view) {
        /*
        Transitions
        -------------
        Added in API 19
        -Fade
        -AutoTransition
        -ChangeBounds
        -TransitionSet

        Added in API 21
        -Slide
        -Explode
        -ChangeClipBounds
        -ChangeImageTransform
        -ChangeTransform
         */

        //code to slide a view off the top of the screen
        Slide slide = new Slide();// our Transition type here is the Slide transition
        slide.setSlideEdge(Gravity.RIGHT);//or TOP or BOTTOM or LEFT

        Explode explode = new Explode();
        explode.setMode(Explode.MODE_IN);

        ChangeImageTransform changeImageTransform = new ChangeImageTransform();



        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        TransitionManager.beginDelayedTransition(root,explode);
        root.setVisibility(View.INVISIBLE);

    }
}
