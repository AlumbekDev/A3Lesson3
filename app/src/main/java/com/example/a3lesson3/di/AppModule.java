package com.example.a3lesson3.di;

import com.example.a3lesson3.data.db.dao.WeatherDao;
import com.example.a3lesson3.data.network.apiservices.WeatherApi;
import com.example.a3lesson3.data.repositories.MainRepository;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)

public abstract class AppModule {

    @Provides
    public static WeatherApi provideApi(Retrofit retrofit)
    {
        return retrofit.create(WeatherApi.class);
    }

    @Provides
    public static Retrofit provideRetroFit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static MainRepository provideMainRepository(WeatherApi api, WeatherDao dao){
        return new MainRepository(api, dao);
    }

    @Provides
    public static OkHttpClient providesOkHttpClient(Interceptor loggingInterceptor){
        return new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }
    @Provides
    public static Interceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}