package co.javimay.weatherapp.data.api.model

data class Main(
    val id: Int,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)