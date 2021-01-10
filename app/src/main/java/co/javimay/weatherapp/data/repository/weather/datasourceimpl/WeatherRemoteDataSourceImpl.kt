package co.javimay.weatherapp.data.repository.weather.datasourceimpl

import co.javimay.weatherapp.data.api.WeatherService
import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherRemoteDataSource
import retrofit2.Response

class WeatherRemoteDataSourceImpl(
    private val weatherService: WeatherService,
    private val apiKey: String
):WeatherRemoteDataSource {
    override suspend fun getWeather(latitude: Double, longitude: Double): Response<Weather> =
        weatherService.getWeather(apiKey, latitude, longitude)
}