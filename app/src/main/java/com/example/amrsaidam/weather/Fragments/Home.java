package com.example.amrsaidam.weather.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amrsaidam.weather.DB.Database;
import com.example.amrsaidam.weather.Interfaces.ResponseInterface;
import com.example.amrsaidam.weather.Models.Response;
import com.example.amrsaidam.weather.Network.ReponseGateWay;
import com.example.amrsaidam.weather.R;
import com.example.amrsaidam.weather.Utilities.Config;

/**
 * Created by amrsaidam on 1/4/19.
 */

public class Home extends Fragment {


    AppCompatButton searchButton, likeButton;
    Config config;
    AppCompatEditText countryName;
    AppCompatTextView temp;
    Database database;
    retrofit2.Response<Response> responses = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.getView(view);
        database = new Database(this.getActivity());
        return view;

    }


    public void like(View view) {
        if (this.responses == null) {
            Toast.makeText(this.getActivity().getBaseContext(), R.string.no_result_to_save, Toast.LENGTH_LONG).show();
            return;
        }
        responses.body().getMain().addData(database);
        Toast.makeText(this.getActivity().getBaseContext(), R.string.data_saved, Toast.LENGTH_LONG).show();
    }


    public void search(View view) {
        config.runProgress();
        String countryName = this.countryName.getText().toString();
        Toast.makeText(this.getActivity().getBaseContext(), countryName, Toast.LENGTH_LONG).show();

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


    private void getView(View view) {
        searchButton = view.findViewById(R.id.search);
        likeButton = view.findViewById(R.id.like);
        config = new Config(this.getActivity());
        countryName = view.findViewById(R.id.countryName);
        temp = view.findViewById(R.id.temp);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(view);
            }
        });
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like(view);
            }
        });
    }

}
