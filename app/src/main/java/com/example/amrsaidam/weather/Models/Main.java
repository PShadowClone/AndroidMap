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

public class Main implements SQLModels {

    public static final String TABLE_NAME = "main";

    public Main() {
    }

    public Main(float temp, float humidity, float pressure, float tempMin, float tempMax) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    @SerializedName("temp")
    private float temp;

    @SerializedName("humidity")
    private float humidity;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("temp_min")
    private float tempMin;

    @SerializedName("temp_max")
    private float tempMax;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }


    @Override
    public String createTable() {
        return "CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "temp FLOAT," +
                "humidity FLOAT," +
                "pressure FLOAT," +
                "temp_min FLOAT," +
                "temp_max FLOAT)";
    }

    @Override
    public String dropTable() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    @Override
    public boolean addData(Database database) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("temp", this.getTemp());
        contentValues.put("humidity", this.getHumidity());
        contentValues.put("pressure", this.getPressure());
        contentValues.put("temp_min", this.getTempMin());
        contentValues.put("temp_max", this.getTempMax());
        long result = db.insert(Weather.TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public Object getData(Database database) {
        SQLiteDatabase db = database.getWritableDatabase();
        String query = "SELECT * FROM " + Weather.TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        List<Main> result = new ArrayList<>();
        while (data.moveToNext()) {
            result.add(new Main(data.getFloat(1), data.getFloat(2), data.getFloat(3), data.getFloat(4), data.getFloat(5)));
        }
        return result;
    }
}
