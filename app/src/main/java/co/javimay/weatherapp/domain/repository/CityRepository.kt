package co.javimay.weatherapp.domain.repository

import co.javimay.weatherapp.data.db.model.City


interface CityRepository {
    suspend fun saveCity(city: City)
    suspend fun getCities(): List<City>?
    suspend fun deleteCities(city: City)
    suspend fun deleteCity(city: City)
}