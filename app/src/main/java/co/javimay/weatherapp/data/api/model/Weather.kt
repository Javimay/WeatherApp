package co.javimay.weatherapp.data.api.model

import com.google.gson.annotations.SerializedName

data class Weather(
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
    @SerializedName("weather")
    val weatherInfo: List<WeatherInfo>,
    val wind: Wind
)