package abroscreative.com.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class ViewAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);


    }

    public void dynamicSet(final View view) {
        //final Button button = (Button) findViewById(R.id.btnDynamicSet);
        AnimationSet animationSet = new AnimationSet(this,null);
        animationSet.addAnimation(new AlphaAnimation(1f,0f));
        animationSet.addAnimation(new TranslateAnimation(0,0,0, -view.getHeight()));
        animationSet.setDuration(2000);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                startActivity(new Intent(ViewAnimActivity.this, MainActivity.class));
                overridePendingTransition(
                        android.R.anim.fade_in,android.R.anim.fade_out
                );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animationSet);
    }
}
