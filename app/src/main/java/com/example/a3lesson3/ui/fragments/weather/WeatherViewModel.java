package com.example.a3lesson3.ui.fragments.weather;

import androidx.lifecycle.MutableLiveData;

import com.example.a3lesson3.base.BaseViewModel;
import com.example.a3lesson3.data.repositories.WeatherRepository;
import com.example.a3lesson3.models.WeatherModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends BaseViewModel {
    String city = "Bishkek";
    private WeatherRepository repository;

    @Inject
    public WeatherViewModel(WeatherRepository repository){
        this.repository =repository;
    }

    MutableLiveData<WeatherModel> getWeather(String city) {
        return repository.getWeather(city);
    }
}

