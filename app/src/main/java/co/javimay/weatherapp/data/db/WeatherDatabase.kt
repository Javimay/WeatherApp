package co.javimay.weatherapp.data.db

import androidx.room.Database
import co.javimay.weatherapp.data.model.City

@Database(
    entities = [City::class],
    version = 1,
    exportSchema = false)
abstract class WeatherDatabase {

    abstract fun cityDao(): CityDao
}