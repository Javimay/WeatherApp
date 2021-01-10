package co.javimay.weatherapp.data.api

import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.utils.serializedNames
import co.javimay.weatherapp.utils.servicesEndPoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(servicesEndPoints.GET_WEATHER)
    suspend fun getWeather(
        @Query(serializedNames.API_KEY) apiKey: String,
        @Query(serializedNames.LAT) lat: Double,
        @Query(serializedNames.LON) lon: Double
    ): Response<Weather>
}
