package com.sanduni.dressme.guesstheflag.util;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.sanduni.dressme.guesstheflag.model.Flag;

import java.util.ArrayList;


public class Helper {

    public static boolean isCounterActivated; //set this true to check timer
    public ArrayList<Flag> flagList = new ArrayList<>();
    public static CountDownTimer countDownTimer;

    //  millisInFuture is set to 12000 & millisUntilFinished is deducted by 1 to
    //  display proper countdown from 10s to 0s.
    public void countTime(final TextView tv, final Button btn) {

        countDownTimer = new CountDownTimer(12000, 1000) {
            public void onTick(long millisUntilFinished) {
                tv.setText("00:" + getSeconds(millisUntilFinished / 1000));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                btn.performClick();
            }
        }.start();

    }

    private String getSeconds(long millisUntilFinished) {
        millisUntilFinished -= 1;
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



