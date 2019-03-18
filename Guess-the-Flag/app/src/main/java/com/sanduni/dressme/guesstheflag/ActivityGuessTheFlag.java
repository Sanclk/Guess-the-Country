package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityGuessTheFlag extends AppCompatActivity {

    ImageView ivCountryImage1, ivCountryImage2, ivCountryImage3; //image views to display the 3 flags
    TextView tvMessage, tvCorrectAns, tvCountDown; //message, correct answer and countdown texts
    Button btnNext;
    String countryName; // randomly generated country name
    String flagName; //displayed flag name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_flag);


//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(btnSubmit.getText().toString().equalsIgnoreCase("Submit")) {
//
//                    String selectedFlag = spnCountries.getSelectedItem().toString();
//
//                    if (selectedFlag.equalsIgnoreCase(countryName)) {
//                        tvMessage.setVisibility(View.VISIBLE);
//                        tvMessage.setText(getString(R.string.txt_correct));
//                        tvMessage.setTextColor(Color.GREEN);
//                        tvCorrectAns.setVisibility(View.INVISIBLE);
//                    } else {
//                        tvMessage.setVisibility(View.VISIBLE);
//                        tvMessage.setText(getString(R.string.txt_wrong));
//                        tvMessage.setTextColor(Color.RED);
//                        tvCorrectAns.setVisibility(View.VISIBLE);
//                        tvCorrectAns.setText(getString(R.string.txt_correct_answer_display) + countryName);
//                    }
//
//                    btnSubmit.setText(getString(R.string.btn_txt_Next));
//                } else if(btnSubmit.getText().toString().equalsIgnoreCase("Next")){
//                    Intent intent = new Intent(ActivityGuessTheFlag.this, ActivityGuessTheFlag.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                }
//            }
//        });
    }

    public void clickedFlag01(View view) {
        checkCorrectAnswer("flagName");
    }

    public void clickedFlag02(View view) {

    }

    public void clickedFlag03(View view) {

    }

    public void checkCorrectAnswer(String flagName){

    }
}
