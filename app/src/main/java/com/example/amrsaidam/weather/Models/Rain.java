package com.example.amrsaidam.weather.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Rain {

    @SerializedName("3h")
    private String thirdH;

    public String getThirdH() {
        return thirdH;
    }

    public void setThirdH(String thirdH) {
        this.thirdH = thirdH;
    }
}
