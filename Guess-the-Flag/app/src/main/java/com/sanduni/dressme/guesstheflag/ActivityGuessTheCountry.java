package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sanduni.dressme.guesstheflag.data.Database;
import com.sanduni.dressme.guesstheflag.model.Flag;
import com.sanduni.dressme.guesstheflag.util.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ActivityGuessTheCountry extends AppCompatActivity {

    ImageView ivCountryImage; //image view to display the flag
    TextView tvMessage, tvCorrectAns, tvCountDown; //message, correct answer and countdown texts
    Spinner spnCountries; //dropdown of the country list
    Button btnSubmit;
    String countryName; // set value to this inside random image selecting algo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_country);

        ivCountryImage = findViewById(R.id.ivCountryImage);
        tvMessage = findViewById(R.id.tvMessage);
        tvCorrectAns = findViewById(R.id.tvCorrectAns);
        tvCountDown= findViewById(R.id.tvCountDown);
        spnCountries = findViewById(R.id.spnCountries);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Database.answers);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spnCountries.setAdapter(dataAdapter);

        Flag flag = Helper.pickRandomImage();
        countryName = flag.getCountryName();
        //Toast.makeText(this, countryName, Toast.LENGTH_LONG).show();
        ivCountryImage.setBackground(getResources().getDrawable(flag.getImage()));

        if(Helper.isCounterActivated){
            tvCountDown.setVisibility(View.VISIBLE);
            Helper.countTime(tvCountDown, btnSubmit);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnSubmit.getText().toString().equalsIgnoreCase("Submit")) {

                    String selectedCountry = spnCountries.getSelectedItem().toString();

                    if (selectedCountry.equalsIgnoreCase(countryName)) { //always ignore case
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText("Correct");
                        tvMessage.setTextColor(Color.GREEN);
                        tvCorrectAns.setVisibility(View.INVISIBLE);
                    } else {
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText("Wrong !");
                        tvMessage.setTextColor(Color.RED);
                        tvCorrectAns.setVisibility(View.VISIBLE);
                        tvCorrectAns.setText("Correct answer : " + countryName);
                    }

                    btnSubmit.setText("Next");
                } else if(btnSubmit.getText().toString().equalsIgnoreCase("Next")){
                    Intent intent = new Intent(ActivityGuessTheCountry.this, ActivityGuessTheCountry.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}