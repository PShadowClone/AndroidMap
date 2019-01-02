package com.example.amrsaidam.weather.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.amrsaidam.weather.Interfaces.GetDataService;
import com.example.amrsaidam.weather.Interfaces.ResponseInterface;
import com.example.amrsaidam.weather.Models.Response;
import com.example.amrsaidam.weather.Network.ReponseGateWay;
import com.example.amrsaidam.weather.Network.RetrofitInstance;
import com.example.amrsaidam.weather.R;
import com.example.amrsaidam.weather.Utilities.Config;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    AppCompatButton button;
    Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.search);
        config = new Config(this);
    }


    public void search(View view) {
        config.runProgress();
        ReponseGateWay.init(new ResponseInterface() {
            @Override
            public void success(retrofit2.Response<Response> response) {

            }

            @Override
            public void Failure(Throwable t) {

            }

            @Override
            public void always(Object t) {
                config.hideProgress();
            }
        });

    }


}
