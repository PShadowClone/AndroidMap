package com.example.amrsaidam.weather.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

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
    private long countryId;

    private String countryName;

    public Main() {
    }

    public Main(float temp, float humidity, float pressure, float tempMin, float tempMax, int countryId) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.tempMin = tempMin;
        this.countryId = countryId;
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


    public void setCountryName(String countryName) {
        this.countryName = countryName;

    }

    public String getCountryName() {
        return this.countryName;

    }

    public Main getInstance() {
        return this;
    }

    public Main setCountryId(long countryId) {
        this.countryId = countryId;
        return this;
    }

    public long getCountryId() {
        return this.countryId;
    }

    @Override
    public String createTable() {
        return "CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "temp FLOAT," +
                "humidity FLOAT," +
                "pressure FLOAT," +
                "temp_min FLOAT," +
                "temp_max FLOAT," +
                "country_id INTEGER)";
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
        contentValues.put("country_id", this.getCountryId());

        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("Inserted id", " " + result);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int updateByCountryId(Database database, int countryId) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("temp", this.getTemp());
        contentValues.put("humidity", this.getHumidity());
        contentValues.put("pressure", this.getPressure());
        contentValues.put("temp_min", this.getTempMin());
        contentValues.put("temp_max", this.getTempMax());
        int result = db.update(TABLE_NAME, contentValues, "id=" + countryId, null);
        return result;
    }


    @Override
    public Object getData(Database database) {
        SQLiteDatabase db = database.getWritableDatabase();
        String query = "SELECT " + TABLE_NAME + ".* , " + Response.TABLE_NAME + ".name FROM " + TABLE_NAME +
                " INNER JOIN " + Response.TABLE_NAME +
                " ON " + TABLE_NAME + ".country_id = " + Response.TABLE_NAME + ".id";
        Cursor data = db.rawQuery(query, null);
        List<Main> result = new ArrayList<>();
        while (data.moveToNext()) {
            Main main = new Main(data.getFloat(0), data.getFloat(1), data.getFloat(2), data.getFloat(3), data.getFloat(4), data.getInt(5));
            main.setCountryName(data.getString(7));
            result.add(main);
        }
        return result;
    }
}
