package co.javimay.weatherapp.domain.repository

import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.data.model.Weather

interface WeatherRepository {
    suspend fun getWeather(city: City): Weather?
    suspend fun updateWeather(city: City): Weather?
}