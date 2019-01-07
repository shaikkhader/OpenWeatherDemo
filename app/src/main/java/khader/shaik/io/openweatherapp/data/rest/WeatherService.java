/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.rest;

import io.reactivex.Single;
import khader.shaik.io.openweatherapp.data.model.Weather;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("data/{version}/forecast")
    Single<Weather> getWeather(@Path("version") String version, @Query("q") String city,@Query("units") String unit, @Query("apikey") String apikey);

}
