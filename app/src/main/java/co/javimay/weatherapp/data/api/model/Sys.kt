package co.javimay.weatherapp.data.api.model

data class Sys(
    val id: Int,
    val country: String,
    val message: Double,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)