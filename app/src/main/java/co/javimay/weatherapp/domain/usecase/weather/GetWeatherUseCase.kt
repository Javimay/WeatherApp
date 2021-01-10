package co.javimay.weatherapp.domain.usecase.weather

import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend fun execute(city: City):Weather? = weatherRepository.getWeather(city)
}