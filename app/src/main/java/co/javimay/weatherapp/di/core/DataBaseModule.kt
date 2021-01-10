package co.javimay.weatherapp.di.core

import android.content.Context
import androidx.room.Room
import co.javimay.weatherapp.data.db.CityDao
import co.javimay.weatherapp.data.db.WeatherDatabase
import co.javimay.weatherapp.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideWeatherDataBase(context: Context): WeatherDatabase = Room.databaseBuilder(
        context, WeatherDatabase::class.java, DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideCityDao(weatherDatabase: WeatherDatabase): CityDao = weatherDatabase.cityDao()

}