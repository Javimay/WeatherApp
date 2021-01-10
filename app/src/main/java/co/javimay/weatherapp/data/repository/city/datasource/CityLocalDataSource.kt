package co.javimay.weatherapp.data.repository.city.datasource

import co.javimay.weatherapp.data.model.City

interface CityLocalDataSource {
    suspend fun getCityFromDB(): List<City>
    suspend fun saveCityToDB(city: City)
    suspend fun updateCityToDB(city: List<City>)
    suspend fun clearAll()
}