package co.javimay.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import co.javimay.weatherapp.data.db.model.City

@Database(
    entities = [City::class],
    version = 1,
    exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun cityDao(): CityDao
}