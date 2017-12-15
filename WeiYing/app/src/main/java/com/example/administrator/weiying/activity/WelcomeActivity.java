package com.example.administrator.weiying.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.weiying.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        iv = (ImageView) findViewById(R.id.iv);

        ObjectAnimator animatorY = new ObjectAnimator().ofFloat(iv,"scaleY",1f,2f);
        ObjectAnimator animatorX = new ObjectAnimator().ofFloat(iv,"scaleX",1f,2f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorY,animatorX);
        animatorSet.setDuration(3000);
        animatorSet.start();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}
