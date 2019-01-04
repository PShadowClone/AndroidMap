package com.example.amrsaidam.weather.Interfaces;

import com.example.amrsaidam.weather.DB.Database;

/**
 * Created by amrsaidam on 1/4/19.
 */

public interface SQLModels {

    public String createTable();

    public String dropTable();

    public boolean addData(Database database);

    public Object getData(Database database);
}
