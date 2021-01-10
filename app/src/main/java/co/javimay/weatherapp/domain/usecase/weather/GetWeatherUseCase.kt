package co.javimay.weatherapp.domain.usecase.weather

import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend fun execute():List<Weather>? = weatherRepository.getWeather()
}