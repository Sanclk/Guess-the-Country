package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class GuessTheCountry extends AppCompatActivity {

    ImageView ivCountryImage; //image view to display the flag
    TextView tvMessage, tvCorrectAns, tvCountDown; //message, correct answer and countdown texts
    Spinner spnCountries; //dropdown of the country list
    Button btnSubmit;
    String realImageName; // set value to this inside random image selecting algo
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_country);
        helper= new Helper();

        ivCountryImage = findViewById(R.id.ivCountryImage);
        tvMessage = findViewById(R.id.tvMessage);
        tvCorrectAns = findViewById(R.id.tvCorrectAns);
        tvCountDown= findViewById(R.id.tvCountDown);
        spnCountries = findViewById(R.id.spnCountries);
        btnSubmit = findViewById(R.id.btnSubmit);

        if(Helper.isCounterActivated){
            tvCountDown.setVisibility(View.VISIBLE);
            helper.countTime(tvCountDown, btnSubmit);
        }

        helper.pickRandomImage();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnSubmit.getText().toString().equalsIgnoreCase("Submit")) {

                    String selectedCountry = spnCountries.getSelectedItem().toString();

                    if (selectedCountry.equalsIgnoreCase(realImageName)) { //always ignore case
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText("Correct");
                        tvMessage.setTextColor(getResources().getColor(R.color.green));
                        tvCorrectAns.setVisibility(View.INVISIBLE);
                    } else {
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText("Wrong !");
                        tvMessage.setTextColor(getResources().getColor(R.color.red));
                        tvCorrectAns.setVisibility(View.VISIBLE);
                        tvCorrectAns.setText("Correct answer : " + realImageName);
                    }

                    btnSubmit.setText("Next");
                } else if(btnSubmit.getText().toString().equalsIgnoreCase("Next")){
                    Intent intent = new Intent(GuessTheCountry.this, GuessTheCountry.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }

}
