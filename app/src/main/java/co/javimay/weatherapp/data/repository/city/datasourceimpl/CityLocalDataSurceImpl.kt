package co.javimay.weatherapp.data.repository.city.datasourceimpl

import co.javimay.weatherapp.data.db.CityDao
import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.data.repository.city.datasource.CityLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityLocalDataSurceImpl(private val cityDao: CityDao):CityLocalDataSource {

    override suspend fun getCityFromDB(): List<City> = cityDao.getCity()

    override suspend fun saveCityToDB(city: City) {
        CoroutineScope(Dispatchers.IO).launch {
            cityDao.saveCity(city)
        }
    }

    override suspend fun updateCityToDB(cities: List<City>) {
        CoroutineScope(Dispatchers.IO).launch {
            cities.forEach {
                cityDao.updateCities(it)
            }
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            cityDao.deleteAllCities()
        }
    }
}