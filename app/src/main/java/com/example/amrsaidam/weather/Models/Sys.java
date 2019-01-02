package com.example.amrsaidam.weather.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Sys {

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private float sunrizse;

    @SerializedName("sunset")
    private float sunset;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getSunrizse() {
        return sunrizse;
    }

    public void setSunrizse(float sunrizse) {
        this.sunrizse = sunrizse;
    }

    public float getSunset() {
        return sunset;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }
}
