package com.sanduni.dressme.guesstheflag;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sanduni.dressme.guesstheflag.util.Helper;

public class ActivityGuessHints extends AppCompatActivity {

    LinearLayout lytHintName;
    Button btnSubmit;
    TextView tvMessage, tvCorrectAns, tvCountDown;
    String countryName = "Sri Lanka";
    int wrongSubmitCount = 0;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_hints);
        helper = new Helper();

        tvCountDown = findViewById(R.id.tvCountDown);
        tvMessage = findViewById(R.id.tvMessage);
        tvCorrectAns = findViewById(R.id.tvCorrectAns);
        btnSubmit = findViewById(R.id.btnSubmit);
        lytHintName = findViewById(R.id.lytNameHint);

        if (Helper.isCounterActivated) {
            tvCountDown.setVisibility(View.VISIBLE);
            helper.countTime(tvCountDown, btnSubmit);
        }

        helper.pickRandomImage();// set value for countryName attribute inside this method.

        generateTextDashes();
    }

    private void generateTextDashes() { //generate dashes according to country name
        int count = getDashCount();
        for (int i = 0; i < count; i++) {

            View vi = LayoutInflater.from(this).inflate(R.layout.hint_text_item, null);
            vi.setId(i);// set id to each child view
            lytHintName.addView(vi, i);
        }
    }

    private String removeNonWordChars(String s) {
        return s.replaceAll("\\W", "");
    }

    public int getDashCount() {
        char[] letterArray = removeNonWordChars(countryName).toCharArray();
        return letterArray.length;
    }

    public void checkAnswer(View view) {
        if (btnSubmit.getText().toString().equalsIgnoreCase("Submit")) {
            String ans = "";
            for (int i = 0; i < lytHintName.getChildCount(); i++) {
                String nameLetter = Character.toString(removeNonWordChars(countryName).charAt(i));
                EditText et = lytHintName.findViewById(i);

                if (et.getText().toString().trim().length() > 0) {//check if input is empty
                    if (nameLetter.equalsIgnoreCase(et.getText().toString())) {//check if each character is matching with country name
                        ans += et.getText().toString();
                    } else {
                        ans += "#";
                    }
                } else {
                    ans += "#";
                }
            }

            if (ans.contains("#")) { //answer incorrect
                wrongSubmitCount += 1;
                if (wrongSubmitCount == 3) {
                    btnSubmit.setText("Next");
                }
            } else { //answer is correct
                tvMessage.setText("CORRECT");
                tvMessage.setTextColor(Color.GREEN);
                tvMessage.setVisibility(View.VISIBLE);
//              stop counter here
                if (Helper.isCounterActivated) {
                    Helper.countDownTimer.cancel();
                }
                btnSubmit.setText("Next");
            }

            if (btnSubmit.getText().toString().equalsIgnoreCase("Submit")) { // allow one more attempt
                setDashText(ans.toCharArray());
            } else if (!ans.equalsIgnoreCase(removeNonWordChars(countryName))) { //answer is wrong
                tvMessage.setText("WRONG !");
                tvMessage.setTextColor(Color.RED);
                tvMessage.setVisibility(View.VISIBLE);

                tvCorrectAns.setText("Correct Answer is : " + removeNonWordChars(countryName));
                tvCorrectAns.setVisibility(View.VISIBLE);
            }
        } else {
            Intent intent = new Intent(this, ActivityGuessHints.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    private void setDashText(char[] checkedAnswer) {
        for (int i = 0; i < lytHintName.getChildCount(); i++) {
            EditText et = lytHintName.findViewById(i);
            if (checkedAnswer[i] == '#') { //incorrect character was there earlier
                et.setText("");
            } else {
                et.setText("" + checkedAnswer[i]);// concatenating "" is required, else ResourceNotFoundException occurs.
                et.setEnabled(false);
                et.setTextColor(Color.BLACK);
            }
        }
        if(Helper.countDownTimer != null) {
            Helper.countDownTimer.cancel(); //cancel previous timer before starting new one.
        }
        helper.countTime(tvCountDown, btnSubmit); //restart Timer
    }
}