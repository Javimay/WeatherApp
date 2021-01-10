package co.javimay.weatherapp.domain.repository

import co.javimay.weatherapp.data.model.City

interface CityRepository {
    suspend fun saveCity(city: City)
    suspend fun getCities(): List<City>?
    suspend fun updateCities(cities:List<City>): List<City>
}