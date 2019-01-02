package com.example.amrsaidam.weather.Interfaces;

import com.example.amrsaidam.weather.Models.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by amrsaidam on 1/2/19.
 */

public interface GetDataService {

    @GET("?appid=57e9c12577f3e045f2e29318fb7fb627&lat=35&lon=139")
    Call<Response> getWeather();
}
