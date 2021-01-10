package co.javimay.weatherapp.data.db

import androidx.room.*
import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.utils.tableNames

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCity(city: City)

    @Query("DELETE FROM ${tableNames.CITY}")
    suspend fun deleteAllCities()

    @Query("SELECT * FROM ${tableNames.CITY}")
    suspend fun getCity(): List<City>

    @Update
    suspend fun updateCities(city: City)
}