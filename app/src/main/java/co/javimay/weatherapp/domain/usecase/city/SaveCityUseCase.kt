package co.javimay.weatherapp.domain.usecase.city

import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.domain.repository.CityRepository

class SaveCityUseCase(private val cityRepository: CityRepository, private val cities: City) {
    suspend fun execute():City? = cityRepository.saveCity(cities)
}