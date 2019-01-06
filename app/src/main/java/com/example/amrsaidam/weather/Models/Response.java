package com.example.amrsaidam.weather.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.amrsaidam.weather.DB.Database;
import com.example.amrsaidam.weather.Interfaces.SQLModels;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Response implements SQLModels {

    public static final String TABLE_NAME = "countries";

    public Response() {
    }

    public Response(int id, String name, int cod, float dt, int liked) {
        this.id = id;
        this.name = name;
        this.cod = cod;
        this.dt = dt;
        this.liked = liked;

    }


    private int liked;

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

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getLiked() {
        return this.liked;
    }

    public Response getInstance() {
        return this;
    }

    @Override
    public String createTable() {
        return "CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "cod INTEGER," +
                "dt FLOAT," +
                "liked INTEGER)";
    }

    @Override
    public String dropTable() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    @Override
    public boolean addData(Database database) {
        return false;
    }


    public long addDataCustom(Database database) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", this.getName());
        contentValues.put("cod", this.getCod());
        contentValues.put("dt", this.getDt());
        contentValues.put("liked", this.getLiked());
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result;
    }

    @Override
    public Object getData(Database database) {
        SQLiteDatabase db = database.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        List<Response> result = new ArrayList<>();
        while (data.moveToNext()) {
            result.add(new Response(data.getInt(0), data.getString(1), data.getInt(2), data.getFloat(3), data.getInt(4)));
        }
        return result;
    }


    public Object getByName(Database database, String name) {
        SQLiteDatabase db = database.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        List<Response> result = new ArrayList<>();
        while (data.moveToNext()) {
            result.add(new Response(data.getInt(0), data.getString(1), data.getInt(2), data.getFloat(3), data.getInt(4)));
        }
        return result;

    }
}
