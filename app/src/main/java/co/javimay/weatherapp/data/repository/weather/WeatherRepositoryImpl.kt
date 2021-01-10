package co.javimay.weatherapp.data.repository.weather

import android.util.Log
import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherRemoteDataSource
import co.javimay.weatherapp.domain.repository.WeatherRepository
import retrofit2.Response
import java.lang.Exception

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
): WeatherRepository {

    companion object{
        val TAG = WeatherRepositoryImpl::class.simpleName
    }

    override suspend fun getWeather(city: City): Weather? {
        val weather: Weather = getWeatherFromAPI(city.latitude, city.longitude)
        return weather
    }

    suspend fun getWeatherFromAPI(latitude: Double, longitude: Double): Weather {
        lateinit var weatherList: Weather
        try {
            val response : Response<Weather> = weatherRemoteDataSource.getWeather(latitude, longitude)
            val body: Weather? = response.body()
            if (body != null){
                weatherList = body
            }
        }catch (exception: Exception){
            Log.i(TAG, exception.message.toString())
        }
        return weatherList
    }
}
