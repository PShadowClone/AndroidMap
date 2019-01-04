package com.example.amrsaidam.weather.Interfaces;

import com.example.amrsaidam.weather.Models.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amrsaidam on 1/2/19.
 */

public interface GetDataService {

    @GET("?appid=57e9c12577f3e045f2e29318fb7fb627")
    Call<Response> getWeather(@Query("q") String country);
}
