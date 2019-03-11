package com.sanduni.dressme.guesstheflag;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.sanduni.dressme.guesstheflag.model.Flag;

import java.util.ArrayList;


public class Helper extends AppCompatActivity{


    public static boolean isCounterActivated;

    public ArrayList<Flag> flagList= new ArrayList <>();



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


    private void addValuesToFlagList(){

//        flagList.add(new Flag("lk","Andorra", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","United Arab Emirates", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Afghanistan", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Antigua and Barbuda", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Anguilla", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Albania", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Armenia", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Netherlands", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Angola", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Antarctica", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Argentina", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","American Samoa", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Austria", getResources().getDrawable(R.drawable.lk)));
//        flagList.add(new Flag("lk","Australia", getResources().getDrawable(R.drawable.lk)));
    }







    public void pickRandomImage() {
        // :)
        //set value to string varible.
        //alse setimage to imageview.
    }


}
