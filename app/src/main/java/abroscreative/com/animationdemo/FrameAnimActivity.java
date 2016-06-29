package abroscreative.com.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class FrameAnimActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        final ImageView imageView = (ImageView) findViewById(R.id.imageFrame);
        imageView.setBackgroundResource(R.drawable.anim_frame);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable animDraw = (AnimationDrawable) imageView.getBackground();
                animDraw.start();


            }
        });
    }
}
