package co.javimay.weatherapp.data.repository.weather.datasource

import co.javimay.weatherapp.data.model.Weather

interface WeatherLocalDataSource {
    suspend fun getWeatherFromDB(cityId: Int): Weather
    suspend fun saveWeatherToDB(weather: Weather)
    suspend fun clearAll()
}