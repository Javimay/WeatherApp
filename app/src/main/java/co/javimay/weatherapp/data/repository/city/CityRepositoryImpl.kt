package co.javimay.weatherapp.data.repository.city

import android.util.Log
import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.data.repository.city.datasource.CityCacheDataSource
import co.javimay.weatherapp.data.repository.city.datasource.CityLocalDataSource
import co.javimay.weatherapp.domain.repository.CityRepository
import co.javimay.weatherapp.domain.repository.WeatherRepository
import java.lang.Exception

class CityRepositoryImpl(
    private val cityCacheDataSource: CityCacheDataSource,
    private val cityLocalDataSource: CityLocalDataSource,
    private val weatherRepository: WeatherRepository
): CityRepository {

    companion object{
        val TAG = CityRepositoryImpl::class.simpleName
    }

    override suspend fun saveCity(city: City) {
        city.weather = weatherRepository.getWeather(city)!!
        cityCacheDataSource.saveCityToCache(city)
        cityLocalDataSource.saveCityToDB(city)
    }

    override suspend fun getCities(): List<City>? = getCitiesFromCache()

    override suspend fun updateCities(cities: List<City>): List<City> {
        cityLocalDataSource.clearAll()
        cities.forEach {
            it.weather = weatherRepository.getWeather(it)!!
            weatherRepository.updateWeather(it)
            cityCacheDataSource.saveCityToCache(it)
        }
        cityLocalDataSource.updateCityToDB(cities)
        return cities
    }

    suspend fun getCitiesFromDB(): List<City>{
        lateinit var citiesList: List<City>
        try {
            citiesList = cityLocalDataSource.getCityFromDB()
        }catch (exception: Exception){
            Log.i(TAG, exception.message.toString())
        }
        return citiesList
    }

    suspend fun getCitiesFromCache(): List<City>{
        lateinit var citiesList: List<City>
        try {
            citiesList = cityCacheDataSource.getCityFromCache()
        }catch (exception: Exception){
            Log.i(TAG, exception.message.toString())
        }
        if (citiesList.isEmpty()){
            citiesList = getCitiesFromDB()
            if(!citiesList.isEmpty()) citiesList.forEach {cityCacheDataSource.saveCityToCache(it)}
        }
        return citiesList
    }
}