package com.example.amrsaidam.weather.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.amrsaidam.weather.Models.Country;
import com.example.amrsaidam.weather.Models.Main;
import com.example.amrsaidam.weather.Models.Response;
import com.example.amrsaidam.weather.Models.Weather;

/**
 * Created by amrsaidam on 1/4/19.
 */

public class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "data.wet";
    private static final int VERSION = 1;

    private Weather weather;
    private Main main;
    private Response response;
    private Country country;
    private Context context;


    public Database(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.weather = new Weather();
        this.main = new Main();
        this.country = new Country();
        this.response = new Response();
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.weather.createTable());
        sqLiteDatabase.execSQL(this.main.createTable());
//        sqLiteDatabase.execSQL(this.country.createTable());
        sqLiteDatabase.execSQL(this.response.createTable());

        Toast.makeText(this.context, "databnase", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(this.weather.dropTable());
        sqLiteDatabase.execSQL(this.main.dropTable());
//        sqLiteDatabase.execSQL(this.country.dropTable());
        sqLiteDatabase.execSQL(this.response.dropTable());
        this.onCreate(sqLiteDatabase);

    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("main", "test");
        contentValues.put("description", "test");
        contentValues.put("icon", "test");

        Log.d("test", "addData: Adding " + item + " to " + Weather.TABLE_NAME);

        long result = db.insert(Weather.TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     *
     * @return
     */
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + Weather.TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
