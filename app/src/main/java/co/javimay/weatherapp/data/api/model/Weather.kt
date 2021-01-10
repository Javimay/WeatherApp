package co.javimay.weatherapp.data.api.model

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
    val weatherInfo: List<WeatherInfo>,
    val wind: Wind
)