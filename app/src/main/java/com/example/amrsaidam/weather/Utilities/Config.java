package com.example.amrsaidam.weather.Utilities;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.amrsaidam.weather.Activities.MainActivity;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Config {

    private ProgressDialog progressDialog;

    public Config(Context context) {
        this.progressDialog = new ProgressDialog(context);
    }

    public void runProgress() {

        this.progressDialog.setMessage("Loading....");
        this.progressDialog.show();
    }


    public void hideProgress() {
        this.progressDialog.hide();
    }

}
