package co.javimay.weatherapp.data.repository.city.datasource

import co.javimay.weatherapp.data.model.City

interface CityCacheDataSource {
    suspend fun getCityFromCache(): List<City>
    suspend fun saveCityToCache(city: City)
}