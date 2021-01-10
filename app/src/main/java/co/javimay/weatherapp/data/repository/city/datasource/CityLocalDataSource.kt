package co.javimay.weatherapp.data.repository.city.datasource

import co.javimay.weatherapp.data.db.model.City


interface CityLocalDataSource {
    suspend fun getCityFromDB(): List<City>
    suspend fun saveCityToDB(city: City)
    suspend fun clearAll()
    suspend fun deleteCity(city: City)
}