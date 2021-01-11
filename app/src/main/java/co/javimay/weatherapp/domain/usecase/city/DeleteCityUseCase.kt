package co.javimay.weatherapp.domain.usecase.city

import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.repository.CityRepository

class DeleteCityUseCase(private val cityRepository: CityRepository) {
    suspend fun execute() = cityRepository.deleteCities()
    suspend fun execute(city: City) = cityRepository.deleteCity(city)
}