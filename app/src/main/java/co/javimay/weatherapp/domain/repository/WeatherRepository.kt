package co.javimay.weatherapp.domain.repository

import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.data.api.model.Weather

interface WeatherRepository {
    suspend fun getWeather(city: City): Weather?
}