package co.javimay.weatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.javimay.weatherapp.utils.tableNames

@Entity(tableName = tableNames.CITY)
data class City(
    @PrimaryKey
    val id: Int,
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val state: Int,
    var weather: Weather
)


