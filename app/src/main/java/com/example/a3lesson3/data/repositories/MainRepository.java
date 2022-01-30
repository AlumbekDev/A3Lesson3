package com.example.a3lesson3.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3lesson3.common.Resource;
import com.example.a3lesson3.data.db.dao.WeatherDao;
import com.example.a3lesson3.data.network.apiservices.WeatherApi;
import com.example.a3lesson3.models.WeatherModel;
import com.example.a3lesson3.ui.fragments.weather.WeatherFragment;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private WeatherApi api;
    private WeatherDao weatherDao;
    private WeatherFragment weatherFragment = new WeatherFragment();

    @Inject
    public MainRepository(WeatherApi api, WeatherDao weatherDao) {
        this.api = api;
        this.weatherDao = weatherDao;
    }

    public MutableLiveData<Resource<WeatherModel>> getWeather(String cityName) {
        MutableLiveData<Resource<WeatherModel>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(Resource.loading());
        api.getWeather(cityName, "955736878ad45c65a461679c139af32a", "metric")
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            weatherDao.deleteAll();
                            mutableLiveData.setValue(Resource.success(response.body()));
                            weatherDao.insertAll(response.body());
                            weatherDao.update(response.body());
                        } else {
                            mutableLiveData.setValue(Resource.error(null, response.message()));
                            weatherDao.delete(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {
                        mutableLiveData.setValue(Resource.error(null, t.getLocalizedMessage()));
                    }
                });
        return mutableLiveData;
    }

    public LiveData<WeatherModel> getAll() {
        return weatherDao.getAll();
    }
}