package com.example.amrsaidam.weather.Network;

import android.util.Log;

import com.example.amrsaidam.weather.Interfaces.GetDataService;
import com.example.amrsaidam.weather.Interfaces.ResponseInterface;
import com.example.amrsaidam.weather.Models.Response;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class ReponseGateWay {

    public static void init(final ResponseInterface responseInterface,  String country) {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Response> call = service.getWeather(country);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.body() == null)
                    responseInterface.always(null);
                else
                responseInterface.success(response);
                responseInterface.always(response);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                responseInterface.Failure(t);
                responseInterface.always(t);
            }
        });
    }
}
