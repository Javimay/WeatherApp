package co.javimay.weatherapp.data.db

import androidx.room.*
import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.utils.CITY

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCity(city: City)

    @Query("DELETE FROM ${CITY}")
    suspend fun deleteAllCities()

    @Delete
    suspend fun deleteCity(city: City)

    @Query("SELECT * FROM ${CITY}")
    suspend fun getCity(): List<City>

    @Update
    suspend fun updateCities(city: City)
}