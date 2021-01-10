package co.javimay.weatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.javimay.weatherapp.utils.tableNames

@Entity(tableName = tableNames.WETHER)
data class Weather(
    @PrimaryKey
    val id: Int,
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val visibility: Int,
    val weatherInfo: List<WeatherInfo>,
    val wind: Wind
)