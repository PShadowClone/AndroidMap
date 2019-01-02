package com.example.amrsaidam.weather.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Response {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("dt")
    private float dt;

    @SerializedName("cod")
    private int cod;

    @SerializedName("clouds")
    private Cloud cloud;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("main")
    private Main main;

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<Weather> weatherList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
