package com.example.a3lesson3.data.network.apiservices;

import com.example.a3lesson3.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    @GET("weather")
    Call<WeatherModel> getWeatherFromBishkek(
            @Query("q") String q,
            @Query("appid") String apikey,
            @Query("units") String units
    );
}
