/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.rest;

import javax.inject.Inject;

import io.reactivex.Single;
import khader.shaik.io.openweatherapp.data.model.Weather;


public class WeatherRepository {


    private final WeatherService weatherService;

    private static final String VERSION = "2.5";

    private static final String API_KEY = "fb11ba8d2dcba0e27a0c607a911e6f28";

    private static final String UNIT = "metric";


    @Inject
    public WeatherRepository(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Single<Weather> getWeatherReportByCity(String cityWithCountryCode) {
        return weatherService.getWeather(VERSION,cityWithCountryCode,UNIT,API_KEY);
    }

}
