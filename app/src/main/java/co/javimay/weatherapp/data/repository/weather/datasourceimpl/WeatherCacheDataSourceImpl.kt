package co.javimay.weatherapp.data.repository.weather.datasourceimpl

import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherCacheDataSource

class WeatherCacheDataSourceImpl: WeatherCacheDataSource {
    private lateinit var weatherList: Weather

    override suspend fun getWeatherFromCache(): Weather = weatherList

    override suspend fun saveWeatherToCache(weather: Weather) {
        weatherList = weather
    }
}