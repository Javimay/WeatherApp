package co.javimay.weatherapp.data.repository.weather.datasource

import co.javimay.weatherapp.data.model.Weather

interface WeatherCacheDataSource {
    suspend fun getWeatherFromCache(): Weather
    suspend fun saveWeatherToCache(weather: Weather)
}