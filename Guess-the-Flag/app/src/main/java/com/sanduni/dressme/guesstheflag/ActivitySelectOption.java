package com.sanduni.dressme.guesstheflag;

import android.app.Activity;

/**
 * Created by Sanduni Chamika
 * w1673755
 * 2017541
 * on 3/18/19
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.sanduni.dressme.guesstheflag.util.Helper;

public class ActivitySelectOption extends AppCompatActivity {

    Switch switch_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);

        switch_timer=findViewById(R.id.switch_timer);
        switch_timer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switch_timer.setText("Timer On");  //Changing the Timer on/off text
                    Helper.isCounterActivated = true;
                }
                else {
                    switch_timer.setText("Timer Off");  //Changing the Timer on/off text
                    Helper.isCounterActivated = false;
                }
            }
        });
    }

    public void loadGuessTheCountry(View view) {
        Intent intent = new Intent(ActivitySelectOption.this, ActivityGuessTheCountry.class);
        startActivity(intent);
    }

    public void loadGuessHints(View view){
        Intent intent = new Intent(ActivitySelectOption.this, ActivityGuessHints.class);
        startActivity(intent);
    }

    public void loadGuessTheFlag(View view) {
        Intent intent = new Intent(ActivitySelectOption.this, ActivityGuessTheFlag.class);
        startActivity(intent);
    }

    public void loadAdvancedLevel(View view) {
        Intent intent = new Intent(ActivitySelectOption.this, ActivityAdvancedLevel.class);
        startActivity(intent);
    }
}