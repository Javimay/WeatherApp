package co.javimay.weatherapp.domain.usecase.city

import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.repository.CityRepository

class DeleteCityUseCase(private val cityRepository: CityRepository, private val cities: City) {
    suspend fun execute() = cityRepository.deleteCities(cities)
}