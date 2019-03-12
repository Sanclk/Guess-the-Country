package com.sanduni.dressme.guesstheflag.util;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import com.sanduni.dressme.guesstheflag.data.Database;
import com.sanduni.dressme.guesstheflag.model.Flag;

import java.util.ArrayList;
import java.util.Random;


public class Helper {

    public static boolean isCounterActivated; //set this true to check timer
    public static ArrayList<Flag> flagList;
    public static CountDownTimer countDownTimer;
    static Random random;

    static {
        initFlagList();
    }

    public static void initFlagList(){
        random = new Random();
        flagList = new ArrayList<>();
        for(int i = 0; i< Database.flags.length; i++){
            flagList.add(new Flag(Database.answers[i], Database.flags[i]));
        }
    }

    //  millisInFuture is set to 12000 & millisUntilFinished is deducted by 1 to
//  display proper countdown from 10s to 0s.
    public static void countTime(final TextView tv, final Button btn) {

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

    private static String getSeconds(long millisUntilFinished) {
        millisUntilFinished -= 1;
        if (millisUntilFinished > 9) {
            return "" + millisUntilFinished;
        }
        return "0" + millisUntilFinished;
    }

    public static Flag pickRandomImage() {
        // :)
        //set value to string varible.
        //alse setimage to imageview.

        return flagList.remove(random.nextInt(flagList.size()));
    }
}



