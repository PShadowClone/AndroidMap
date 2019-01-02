package com.example.amrsaidam.weather.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Main {

    @SerializedName("temp")
    private float temp;

    @SerializedName("humidity")
    private float humidity;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("temp_min")
    private float tempMin;

    @SerializedName("temp_max")
    private float tempMax;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
}
