package com.example.amrsaidam.weather.Models;

import com.example.amrsaidam.weather.DB.Database;
import com.example.amrsaidam.weather.Interfaces.SQLModels;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amrsaidam on 1/2/19.
 */

public class Weather implements SQLModels{

    public static final String TABLE_NAME = "weathers";

    @SerializedName("id")
    private int id;

    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public  String createTable() {
        return "CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "main TEXT," +
                "description TEXT," +
                "icon TEXT)";
    }

    public  String dropTable() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    @Override
    public boolean addData(Database database) {
        return false;
    }

    @Override
    public Object getData(Database database) {
        return null;
    }

}
