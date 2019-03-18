package com.sanduni.dressme.guesstheflag;

/**
 * Created by Sanduni Chamika
 * w1673755
 * 2017541
 */

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

import com.sanduni.dressme.guesstheflag.data.Database;
import com.sanduni.dressme.guesstheflag.model.Flag;
import com.sanduni.dressme.guesstheflag.util.Helper;

public class ActivityGuessTheCountry extends AppCompatActivity {

    ImageView ivCountryImage; //image view to display the flag
    TextView tvMessage, tvCorrectAns, tvCountDown; //message, correct answer and countdown texts
    Spinner spnCountries; //dropdown of the country list
    Button btnSubmit;
    String countryName; // country name of the randomly generated flag

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

        // Creating an adapter for spinner
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

        //adding the advertisement
        new AdHandeler().loadInterstitialAd(this);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnSubmit.getText().toString().equalsIgnoreCase("Submit")) {

                    String selectedCountry = spnCountries.getSelectedItem().toString();

                    if (selectedCountry.equalsIgnoreCase(countryName)) {
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText(getString(R.string.txt_correct));
                        tvMessage.setTextColor(Color.GREEN);
                        tvCorrectAns.setVisibility(View.INVISIBLE);
                    } else {
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText(getString(R.string.txt_wrong));
                        tvMessage.setTextColor(Color.RED);
                        tvCorrectAns.setVisibility(View.VISIBLE);
                        tvCorrectAns.setText(getString(R.string.txt_correct_answer_display) + countryName);
                    }

                    btnSubmit.setText(getString(R.string.btn_txt_Next));
                } else if(btnSubmit.getText().toString().equalsIgnoreCase("Next")){
                    Intent intent = new Intent(ActivityGuessTheCountry.this, ActivityGuessTheCountry.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}