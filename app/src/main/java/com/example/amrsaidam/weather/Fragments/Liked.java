package com.example.amrsaidam.weather.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amrsaidam.weather.Adapters.MainAdapter;
import com.example.amrsaidam.weather.DB.Database;
import com.example.amrsaidam.weather.Models.Main;
import com.example.amrsaidam.weather.R;

import java.util.List;

/**
 * Created by amrsaidam on 1/5/19.
 */

public class Liked extends Fragment {


    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private Database database;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);

        Main main = new Main();
        database = new Database(this.getActivity().getBaseContext());
        adapter = new MainAdapter((List<Main>) main.getData(database));
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);




        return view;

    }
}
