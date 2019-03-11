package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SelectOption extends AppCompatActivity {

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
        Intent intent = new Intent(SelectOption.this, GuessTheCountry.class);
        startActivity(intent);
    }

    public void loadGuessHints(View view){
        Intent intent = new Intent(SelectOption.this,GuessHints.class);
        startActivity(intent);
    }

    public void loadGuessTheFlag(View view) {
        Intent intent = new Intent(SelectOption.this, GuessTheFlag.class);
        startActivity(intent);
    }

    public void advancedLevel(View view){
        Intent intent = new Intent(SelectOption.this,AdvancedLevel.class);
        startActivity(intent);
    }
}
