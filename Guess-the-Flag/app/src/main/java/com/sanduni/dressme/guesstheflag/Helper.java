package com.sanduni.dressme.guesstheflag;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Helper extends AppCompatActivity {


    public static boolean isCounterActivated;

    public void countTime(final TextView tv, final Button btn) {

        new CountDownTimer(11000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv.setText("00:" + getSeconds(millisUntilFinished / 1000));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                tv.setText("00:00");
                btn.performClick();
            }

        }.start();
    }

    private String getSeconds(long millisUntilFinished) {
        if (millisUntilFinished > 9) {
            return "" + millisUntilFinished;
        }
        return "0" + millisUntilFinished;
    }

    public void pickRandomImage() {
        // :)
        //set value to string varible.
        //alse setimage to imageview.
    }
}
