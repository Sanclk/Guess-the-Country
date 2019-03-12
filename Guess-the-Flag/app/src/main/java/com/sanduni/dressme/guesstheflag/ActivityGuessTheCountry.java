package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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
    String realImageName; // set value to this inside random image selecting algo
    Helper helper;
    List <Flag> flagList;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_country);
        random = new Random();
        helper= new Helper();

        ivCountryImage = findViewById(R.id.ivCountryImage);
        tvMessage = findViewById(R.id.tvMessage);
        tvCorrectAns = findViewById(R.id.tvCorrectAns);
        tvCountDown= findViewById(R.id.tvCountDown);
        spnCountries = findViewById(R.id.spnCountries);
        btnSubmit = findViewById(R.id.btnSubmit);


        flagList = new ArrayList<>();

        //adding all flags and names to the flagList
        for(int i = 0; i< Database.answers.length; i++){
            flagList.add(new Flag(Database.answers[i],Database.flags[i]));
        }

        //shuffling the flags
        Collections.shuffle(flagList);

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
                        tvMessage.setTextColor(Color.GREEN);
                        tvCorrectAns.setVisibility(View.INVISIBLE);
                    } else {
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText("Wrong !");
                        tvMessage.setTextColor(Color.RED);
                        tvCorrectAns.setVisibility(View.VISIBLE);
                        tvCorrectAns.setText("Correct answer : " + realImageName);
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

    private void newQuestion(int number){
        //setting the image of the flag to the screen
        ivCountryImage.setImageResource(flagList.get(number-1).getImage());
        //TODO
        int correctAnswer = random.nextInt()+1;

    }

    private Flag pickFlag(){
        return flagList.remove(random.nextInt(flagList.size()));
    }

}
