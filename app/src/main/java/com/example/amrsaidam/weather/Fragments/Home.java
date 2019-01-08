package com.example.amrsaidam.weather.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.amrsaidam.weather.DB.Database;
import com.example.amrsaidam.weather.Interfaces.ResponseInterface;
import com.example.amrsaidam.weather.Models.Response;
import com.example.amrsaidam.weather.Network.ReponseGateWay;
import com.example.amrsaidam.weather.R;
import com.example.amrsaidam.weather.Utilities.Config;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by amrsaidam on 1/4/19.
 */

public class Home extends Fragment {


    AppCompatButton searchButton, likeButton;
    Config config;
    AppCompatTextView temp, min_temp, max_temp, pressure, humidity, countryName;
    Database database;
    retrofit2.Response<Response> responses = null;
    String searchedValue;
    LinearLayoutCompat result;
    RelativeLayout noResult;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.getView(view);
        database = new Database(this.getActivity());
        try {
            searchedValue = getArguments().getString("searchedValue");
            this.search(searchedValue);
        } catch (NullPointerException nullPointerException) {
        }
        return view;

    }


    public void like(View view) {
        if (this.responses == null) {
            Toast.makeText(this.getActivity().getBaseContext(), R.string.no_result_to_save, Toast.LENGTH_LONG).show();
            return;
        }
        Response response = responses.body();
        List<Response> dbResponse = (List<Response>) response.getByName(database, searchedValue);
        likeButton.setText("\uf004");
        if (dbResponse.size() > 0) {
            responses.body().getMain().getInstance().updateByCountryId(database, dbResponse.get(0).getId());
            Toast.makeText(this.getActivity().getBaseContext(), R.string.value_existed, Toast.LENGTH_LONG).show();
            return;
        }

        long countryId = response.addDataCustom(database);

        responses.body().getMain().getInstance().setCountryId(countryId).addData(database);
        Toast.makeText(this.getActivity().getBaseContext(), R.string.data_saved, Toast.LENGTH_LONG).show();
    }


    public void search(String searchedVvalue) {
        config.runProgress();
        final String countryNameForSearch = searchedVvalue;
        ReponseGateWay.init(new ResponseInterface() {
            @Override
            public void success(retrofit2.Response<Response> response) {
                Log.d("test Temp", "" + response.body().getMain().getTemp());
                temp.setText(" " + response.body().getMain().getTemp());
                min_temp.setText(" " + response.body().getMain().getTempMin());
                max_temp.setText(" " + response.body().getMain().getTempMax());
                pressure.setText(" " + response.body().getMain().getPressure());
                humidity.setText(" " + response.body().getMain().getHumidity());
                countryName.setText(" " + countryNameForSearch);
                responses = response;
                Animation aniFade = AnimationUtils.loadAnimation(Home.this.getActivity().getApplicationContext(), R.anim.fade_in);
                Animation aoutFade = AnimationUtils.loadAnimation(Home.this.getActivity().getApplicationContext(), R.anim.fade_out);

//
                noResult.setAnimation(aoutFade);
                noResult.setVisibility(View.GONE);
                result.setAnimation(aniFade);
                result.setVisibility(View.VISIBLE);


                List<Response> dbResponse = (List<Response>) responses.body().getByName(database, searchedValue);
                if (dbResponse.size() > 0) {
                    responses.body().getMain().getInstance().updateByCountryId(database, dbResponse.get(0).getId());
                    Toast.makeText(Home.this.getActivity().getBaseContext(), R.string.value_existed, Toast.LENGTH_LONG).show();
                    likeButton.setText("\uf004");
                }
//                noResult.setVisibility(View.GONE);
            }

            @Override
            public void Failure(Throwable t) {


            }

            @Override
            public void always(Object t) {
                if(t == null)
                    Toast.makeText(Home.this.getActivity().getBaseContext() , "Invalid country name",Toast.LENGTH_LONG).show();
                else if(t instanceof UnknownHostException)
                    Toast.makeText(Home.this.getActivity().getBaseContext() , "No internet connection",Toast.LENGTH_LONG).show();
                Log.d("Exception" , t.toString());
                config.hideProgress();
            }
        }, countryNameForSearch);

    }


    private void getView(View view) {
        searchButton = view.findViewById(R.id.search);
        likeButton = view.findViewById(R.id.like);
        config = new Config(this.getActivity());
//        countryName = view.findViewById(R.id.countryName);
        temp = view.findViewById(R.id.temp);
        min_temp = (AppCompatTextView) view.findViewById(R.id.min_temp);
        max_temp = (AppCompatTextView) view.findViewById(R.id.max_temp);
        pressure = (AppCompatTextView) view.findViewById(R.id.pressure);
        humidity = (AppCompatTextView) view.findViewById(R.id.humidity);
        countryName = (AppCompatTextView) view.findViewById(R.id.countryName);
        result = (LinearLayoutCompat) view.findViewById(R.id.resultContainer);
        noResult = (RelativeLayout) view.findViewById(R.id.noResult);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like(view);
            }
        });
    }

}
