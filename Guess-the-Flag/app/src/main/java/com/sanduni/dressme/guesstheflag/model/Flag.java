package com.sanduni.dressme.guesstheflag.model;

import android.graphics.drawable.Drawable;

public class Flag {

    private String countryCode;
    private String countryName;
    private Drawable imageDrawable;

    public Flag(){

    }

    public Flag(String countryCode, String countryName, Drawable imageDrawable) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.imageDrawable = imageDrawable;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}
