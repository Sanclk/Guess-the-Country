package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageButton imgBtnPlay;
    ImageView imgWorld;
    Animation fromBottom, fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgWorld = findViewById(R.id.imgWorld);
        imgBtnPlay = findViewById(R.id.imgBtnPlay);

        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.from_top);

        imgWorld.setAnimation(fromTop);
        imgBtnPlay.setAnimation(fromBottom);
    }

    public void loadHome(View view) {
        Intent intent = new Intent(this, ActivitySelectOption.class);
        startActivity(intent);
    }
}
