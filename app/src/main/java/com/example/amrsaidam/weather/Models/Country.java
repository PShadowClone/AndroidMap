package com.example.amrsaidam.weather.Models;

import com.example.amrsaidam.weather.Interfaces.SQLModels;

/**
 * Created by amrsaidam on 1/4/19.
 */

public class Country  implements SQLModels{

    public static final String TABLE_NAME = "countries";
    private String name;
    private boolean liked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public String createTable() {
        return "CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "liked int)";
    }

    @Override
    public String dropTable() {
        return "DROP TABLE IF EXISTS "+TABLE_NAME;
    }
}
