package com.example.amrsaidam.weather.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.amrsaidam.weather.DB.Database;
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
    AppCompatEditText countryName;
    AppCompatTextView temp;
    Database database;
    retrofit2.Response<Response> responses = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getView();
        database = new Database(this);
    }

    public void like(View view) {
        if (this.responses == null) {
            Toast.makeText(this.getBaseContext(), R.string.no_result_to_save, Toast.LENGTH_LONG).show();
            return;
        }
        responses.body().getMain().addData(database);
        Toast.makeText(this.getBaseContext(), R.string.data_saved, Toast.LENGTH_LONG).show();
    }


    public void search(View view) {
        config.runProgress();
        String countryName = this.countryName.getText().toString();
        Toast.makeText(this.getBaseContext(), countryName, Toast.LENGTH_LONG).show();

        ReponseGateWay.init(new ResponseInterface() {
            @Override
            public void success(retrofit2.Response<Response> response) {
                temp.setText(" " + response.body().getMain().getTemp());
                responses = response;
            }

            @Override
            public void Failure(Throwable t) {

            }

            @Override
            public void always(Object t) {

                config.hideProgress();
            }
        }, countryName);

    }


    private void getView() {
        button = findViewById(R.id.search);
        config = new Config(this);
        countryName = findViewById(R.id.countryName);
        temp = findViewById(R.id.temp);
    }


}
