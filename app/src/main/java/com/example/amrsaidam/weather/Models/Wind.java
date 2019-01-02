package com.example.amrsaidam.weather.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Wind {

    @SerializedName("speed")
    private float speed;

    @SerializedName("deg")
    private float deg;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }
}
