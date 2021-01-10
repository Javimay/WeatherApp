package co.javimay.weatherapp.domain.usecase.city

import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.domain.repository.CityRepository

class UpdateCityUseCase(private val cityRepository: CityRepository, private val cities: List<City>) {
    suspend fun execute():List<City>? = cityRepository.updateCities(cities)
}