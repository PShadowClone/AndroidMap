package com.example.amrsaidam.weather.Adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amrsaidam.weather.Models.Main;
import com.example.amrsaidam.weather.R;

import java.util.List;

/**
 * Created by amrsaidam on 1/5/19.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Main> mains;

    public MainAdapter(List<Main> mains) {
        this.mains = mains;

    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.humidity.setText("" + this.mains.get(position).getHumidity());
        holder.min_temp.setText("" + this.mains.get(position).getTempMin());
        holder.max_temp.setText("" + this.mains.get(position).getTempMax());
        holder.pressure.setText("" + this.mains.get(position).getPressure());
        holder.temp.setText("" + this.mains.get(position).getTemp());
        holder.countryName.setText("" + this.mains.get(position).getCountryName());

    }

    @Override
    public int getItemCount() {
        return this.mains.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView temp, min_temp, max_temp, humidity, pressure, countryName;


        MainViewHolder(View itemView) {
            super(itemView);
            temp = (AppCompatTextView) itemView.findViewById(R.id.temp);
            min_temp = (AppCompatTextView) itemView.findViewById(R.id.min_temp);
            max_temp = (AppCompatTextView) itemView.findViewById(R.id.max_temp);
            humidity = (AppCompatTextView) itemView.findViewById(R.id.humidity);
            pressure = (AppCompatTextView) itemView.findViewById(R.id.pressure);
            countryName = (AppCompatTextView) itemView.findViewById(R.id.countryName);

        }
    }
}



