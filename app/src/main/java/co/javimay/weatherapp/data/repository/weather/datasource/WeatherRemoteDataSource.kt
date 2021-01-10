package co.javimay.weatherapp.data.repository.weather.datasource

import co.javimay.weatherapp.data.model.Weather
import retrofit2.Response

interface WeatherRemoteDataSource {
    suspend fun getWeather(latitude: Double, longitude:Double): Response<Weather>
}