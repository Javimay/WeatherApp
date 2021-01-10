package co.javimay.weatherapp.domain.usecase.city

import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.repository.CityRepository

class GetCityUseCase(private val cityRepository: CityRepository) {
    suspend fun execute():List<City>? = cityRepository.getCities()
}