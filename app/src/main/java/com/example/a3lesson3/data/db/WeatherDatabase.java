package com.example.a3lesson3.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.a3lesson3.data.db.dao.WeatherDao;
import com.example.a3lesson3.models.WeatherModel;

@TypeConverters(TypeConverter.class)
@Database(entities = {WeatherModel.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao();
}
