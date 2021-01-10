package co.javimay.weatherapp.data.api.model

data class WeatherInfo(
    val id: Int,
    val description: String,
    val icon: String,
    val main: String
)