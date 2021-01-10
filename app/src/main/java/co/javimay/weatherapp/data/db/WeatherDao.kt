package co.javimay.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.utils.tableNames

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeather(weather: Weather)

    @Query("DELETE FROM ${tableNames.WETHER}")
    suspend fun deleteAllWeather()

    @Query("SELECT * FROM ${tableNames.WETHER} WHERE id = :cityId")
    suspend fun getWeather(cityId: Int): Weather
}