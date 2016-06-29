package abroscreative.com.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchViewAnimations(View view) {
        startActivity(new Intent(this, ViewAnimActivity.class));
    }

    public void launchPropertyAnimations(View view) {
        startActivity(new Intent(this,PropertyAnimatorActivity.class));
    }

    public void launchFrameAnimation(View view) {
        startActivity(new Intent(this, FrameAnimActivity.class));
    }

    public void launchTransitionAnimations(View view) {
        startActivity(new Intent(this, TransitionActivity.class));
    }
}
