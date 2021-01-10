package co.javimay.weatherapp.di.core

import co.javimay.weatherapp.data.api.WeatherService
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherRemoteDataSource
import co.javimay.weatherapp.data.repository.weather.datasourceimpl.WeatherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(weatherService: WeatherService): WeatherRemoteDataSource
            = WeatherRemoteDataSourceImpl(weatherService, apiKey)
}