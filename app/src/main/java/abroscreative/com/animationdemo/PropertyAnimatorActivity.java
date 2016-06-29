package abroscreative.com.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class PropertyAnimatorActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        image = (ImageView) findViewById(R.id.image);

    }

    public void animate(View view) {
        fab.setScaleX(0);
        fab.setScaleY(0);
        fab.animate().setDuration(2500).scaleX(1).scaleY(1).start();//1 for original size 2 for double original size 0 for invisible
    }

    public void objectAnimatorScale(View view) {
        ObjectAnimator.ofFloat(image,"scaleX", 0, 2).start();
    }

    public void objectAnimatorRotate(View view) {
        ObjectAnimator.ofFloat(image,"rotation", 0, 720).setDuration(4000).start();
    }

    public void objectAnimatorAlpha(View view) {
        ObjectAnimator.ofFloat(image, "alpha", 0, 1).setDuration(3000).start();
    }

    //Using AnimatorSet to execute choreographed animations
    public void objectAnimatorSet(View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(image,"alpha",.2f,2.0f).setDuration(3000);
        ObjectAnimator scaleY= ObjectAnimator.ofFloat(image, "scaleY", .05f,1.5f).setDuration(3000);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(image, "scaleX", .05f,1.5f).setDuration(3000);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 0, 720).setDuration(3000);
        set.playSequentially(alpha,scaleY,scaleX,rotate);
        //set.playTogether(alpha,scaleY,scaleX,rotate);
        set.start();

    }

    //setting interpolators for more realistic motion
    public void objectInterpolator(View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(image,"alpha",.2f,2.0f).setDuration(3000);
        ObjectAnimator scaleY= ObjectAnimator.ofFloat(image, "scaleY", 1,2).setDuration(3000);
        set.playSequentially(alpha,scaleY);
        //set.playTogether(alpha,scaleY);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

    //setting objectAnimator from xml
    public void launchStaticAnimator(View view) {

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_alpha);
        animator.setTarget(image);
        animator.start();
    }


}
