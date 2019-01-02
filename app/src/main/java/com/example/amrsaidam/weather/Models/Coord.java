package com.example.amrsaidam.weather.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Coord {

    @SerializedName("lon")
    private float lon;

    @SerializedName("lat")
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
