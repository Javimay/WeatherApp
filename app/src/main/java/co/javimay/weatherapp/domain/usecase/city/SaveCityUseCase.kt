package co.javimay.weatherapp.domain.usecase.city

import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.repository.CityRepository

class SaveCityUseCase(private val cityRepository: CityRepository) {
    suspend fun execute(cities: City) = cityRepository.saveCity(cities)
}