package com.example.a3lesson3.data.network.apiservices;

import com.example.a3lesson3.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("data/2.5/weather")
    Call<WeatherModel> getWeather(@Query("q") String cityName,
                                 @Query("appid") String appid,
                                 @Query("units") String units);
}