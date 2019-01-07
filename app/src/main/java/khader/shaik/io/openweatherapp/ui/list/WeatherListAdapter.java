/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.ui.list;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import khader.shaik.io.openweatherapp.R;
import khader.shaik.io.openweatherapp.data.model.Data;
import khader.shaik.io.openweatherapp.util.DateUtil;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>{

    private WeatherDataSelectionListener weatherDataSelectionListener;
    private final List<Data> data = new ArrayList<>();
    public Context mContext;

    WeatherListAdapter(WeatherListViewModel viewModel, Context context, LifecycleOwner lifecycleOwner, WeatherDataSelectionListener weatherDataSelectionListener) {
        this.weatherDataSelectionListener = weatherDataSelectionListener;
        this.mContext = context;
        viewModel.getWeather().observe(lifecycleOwner, weather -> {
            data.clear();
            if (weather != null) {
                data.addAll(Arrays.asList(weather.getData()));
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_weather_data_list_item, parent, false);
        return new WeatherViewHolder(view,mContext, weatherDataSelectionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class WeatherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weather_time) TextView weatherTime;
        @BindView(R.id.weather_temperature) TextView weatherTemperature;

        private Data data;
        private Context context;

        WeatherViewHolder(View itemView,Context context, WeatherDataSelectionListener weatherDataSelectionListener) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if(data != null) {
                    weatherDataSelectionListener.onDataSelected(data);
                }
            });
        }

        void bind(Data data) {
            this.data = data;
            weatherTime.setText(DateUtil.getDateCurrentTimeZone(this.data.getDt()));
            weatherTemperature.setText(Html.fromHtml(String.format(context.getResources().getString(R.string.weather_celcius_units),this.data.getMain().getTemp_max())));
        }
    }
}
