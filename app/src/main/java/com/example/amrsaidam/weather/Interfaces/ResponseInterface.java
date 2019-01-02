package com.example.amrsaidam.weather.Interfaces;

import com.example.amrsaidam.weather.Models.Response;

import retrofit2.Call;

/**
 * Created by amrsaidam on 1/2/19.
 */

public interface ResponseInterface{

    public void success(retrofit2.Response<Response> response);
    public void Failure(Throwable t);
    public void always(Object t);
}
