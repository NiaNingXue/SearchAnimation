package com.nianing.searchanimation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private long START_ANIMATION_DURATION = 600;
    private Animation mStartAnimation;
    private SearchDrawable searchDrawable;
    private ImageView imageView;
    boolean back = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.search);
        searchDrawable = new SearchDrawable();
        imageView.setImageDrawable(searchDrawable);
        startUpAnimation();
        imageView.setOnClickListener(this);
    }

    private void startUpAnimation() {
        mStartAnimation = new Animation() {
            @Override
            public void applyTransformation(float interpolatedTime, Transformation t) {
                if(back){
                    searchDrawable.setPhase(1-interpolatedTime);
                }else{
                    searchDrawable.setPhase(interpolatedTime);
                }
            }
        };
        mStartAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        mStartAnimation.setDuration(START_ANIMATION_DURATION);
    }

    @Override
    public void onClick(View v) {
      imageView.startAnimation(mStartAnimation);
      back = !back;
    }
}
