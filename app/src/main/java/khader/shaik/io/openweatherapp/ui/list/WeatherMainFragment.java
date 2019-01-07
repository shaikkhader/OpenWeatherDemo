/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.ui.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import khader.shaik.io.openweatherapp.R;
import khader.shaik.io.openweatherapp.base.BaseFragment;
import khader.shaik.io.openweatherapp.data.binding.SearchFields;
import khader.shaik.io.openweatherapp.data.model.Data;
import khader.shaik.io.openweatherapp.databinding.WeatherlistBinding;
import khader.shaik.io.openweatherapp.util.ViewModelFactory;

public class WeatherMainFragment extends BaseFragment implements WeatherDataSelectionListener {

    @BindView(R.id.recyclerView) RecyclerView listView;
    @BindView(R.id.tv_error) TextView errorTextView;
    @BindView(R.id.loading_view) View loadingView;
    @BindView(R.id.search_text) EditText searchText;
    @BindView(R.id.search_go_button) Button searchButton;

    @Inject
    ViewModelFactory viewModelFactory;

    private WeatherListViewModel viewModel;

    @Override
    protected int layoutRes() {
        return R.layout.weatherlist;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherListViewModel.class);
        WeatherlistBinding weatherlistBinding = DataBindingUtil.bind(view);
        weatherlistBinding.setModel(viewModel);
        listView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        listView.setAdapter(new WeatherListAdapter(viewModel, getBaseActivity(),this, this));
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        observableViewModel();
    }

    @Override
    public void onDataSelected(Data data) {
        //TODO: Not yet filled
    }

    private void observableViewModel() {

        viewModel.getSearchFields().observe(this, new Observer<SearchFields>() {
            @Override
            public void onChanged(@Nullable SearchFields searchFields) {
                Log.d("Fields","Search Fields"+searchFields);
                viewModel.getWeather(searchFields);
            }
        });
        viewModel.getWeather().observe(this, weather -> {
            if (weather != null && weather.getCod().equalsIgnoreCase("200")){
                listView.setVisibility(View.VISIBLE);
            }
        });

        viewModel.getError().observe(this, isError -> {
            if (isError != null) if(isError) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                errorTextView.setText("An Error Occurred While Loading Data!");
            }else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });

        viewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
    }
}
