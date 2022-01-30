package com.example.a3lesson3.ui.fragments.weather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3lesson3.common.Resource;
import com.example.a3lesson3.data.repositories.MainRepository;
import com.example.a3lesson3.models.WeatherModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {
    private MainRepository repository;
    public LiveData<Resource<WeatherModel>> liveData;
    public LiveData<WeatherModel> localLiveData;

    @Inject
    public WeatherViewModel(MainRepository repository) {
        this.repository=repository;
    }

    public void getWeather(String cityName){
        liveData=repository.getWeather(cityName);
    }

    public void getAll() {
        localLiveData = repository.getAll();
    }
}

