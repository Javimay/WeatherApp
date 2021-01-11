package co.javimay.weatherapp.data.repository.city

import android.util.Log
import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.data.repository.city.datasource.CityLocalDataSource
import co.javimay.weatherapp.domain.repository.CityRepository
import java.lang.Exception

class CityRepositoryImpl(
    private val cityLocalDataSource: CityLocalDataSource
): CityRepository {

    companion object{
        val TAG = CityRepositoryImpl::class.simpleName
    }

    override suspend fun saveCity(city: City) {
        cityLocalDataSource.saveCityToDB(city)
    }

    override suspend fun getCities(): List<City>? = getCitiesFromDB()

    override suspend fun deleteCities() {
        cityLocalDataSource.clearAll()
    }

    override suspend fun deleteCity(city: City) {
        cityLocalDataSource.deleteCity(city)
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
}