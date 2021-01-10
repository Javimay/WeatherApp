package co.javimay.weatherapp.data.api

import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.utils.API_KEY
import co.javimay.weatherapp.utils.GET_WEATHER
import co.javimay.weatherapp.utils.LAT
import co.javimay.weatherapp.utils.LON
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(GET_WEATHER)
    suspend fun getWeather(
        @Query(API_KEY) apiKey: String,
        @Query(LAT) lat: Double,
        @Query(LON) lon: Double
    ): Response<Weather>
}
