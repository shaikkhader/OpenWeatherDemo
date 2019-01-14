/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import khader.shaik.io.openweatherapp.data.binding.SearchFields;
import khader.shaik.io.openweatherapp.data.binding.SearchForm;
import khader.shaik.io.openweatherapp.data.model.Weather;
import khader.shaik.io.openweatherapp.data.rest.WeatherRepository;

public class WeatherListViewModel extends ViewModel {


    private final WeatherRepository weatherRepository;
    private final MutableLiveData<Weather> weather = new MutableLiveData<>();
    private final MutableLiveData<Boolean> weatherDataLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable;
    private View.OnFocusChangeListener onSearchTextField;
    private SearchForm search;

    @Inject
    public WeatherListViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        disposable = new CompositeDisposable();
        init();
    }

    @BindingAdapter("onFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public LiveData<Boolean> getError() {
        return weatherDataLoadError;
    }

    public MutableLiveData<Weather> getWeather() {
        return weather;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<SearchFields> getSearchFields() {
        return search.getSearchFields();
    }

    public SearchForm getSearch() {
        return search;
    }

    private void init() {
        search = new SearchForm();
        onSearchTextField = new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    search.isSearchTextValid(true);
                }
            }
        };


        loading.setValue(true);


    }

    public View.OnFocusChangeListener getSearchTextOnFocusChangeListener() {
        return onSearchTextField;
    }

    public void onButtonClick() {
        search.onClick();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

    public void getWeather(SearchFields searchFields) {
        disposable.add(weatherRepository.getWeatherReportByCity(searchFields.getSearchText()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<Weather>() {
                    @Override
                    public void onSuccess(Weather value) {
                        weatherDataLoadError.setValue(false);
                        weather.setValue(value);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        weatherDataLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));

    }
}
