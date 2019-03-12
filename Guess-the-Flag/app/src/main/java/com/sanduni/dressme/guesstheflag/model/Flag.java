package com.sanduni.dressme.guesstheflag.model;

import android.graphics.drawable.Drawable;

public class Flag {

    private String countryName;
    private int image;

    public Flag(String countryName, int image) {
        this.countryName = countryName;
        this.image = image;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getImage() {
        return image;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
