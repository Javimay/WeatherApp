package co.javimay.weatherapp.domain.usecase.weather

import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.domain.repository.WeatherRepository

class UpdateWatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend fun execute(city: City):Weather? = weatherRepository.updateWeather(city)
}