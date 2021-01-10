package co.javimay.weatherapp.data.repository.weather

import android.util.Log
import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherCacheDataSource
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherLocalDataSource
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherRemoteDataSource
import co.javimay.weatherapp.domain.repository.WeatherRepository
import retrofit2.Response
import java.lang.Exception

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherCacheDataSource: WeatherCacheDataSource
): WeatherRepository {

    companion object{
        val TAG = WeatherRepositoryImpl::class.simpleName
    }

    override suspend fun getWeather(city: City): Weather? {
        val weather: Weather = getWeatherFromAPI(city.latitude, city.longitude)
        weatherLocalDataSource.saveWeatherToDB(weather)
        weatherCacheDataSource.saveWeatherToCache(weather)
        return weather
    }

    override suspend fun updateWeather(city: City): Weather? {
        val weather: Weather = getWeatherFromAPI(city.latitude, city.longitude)
        weatherLocalDataSource.saveWeatherToDB(weather)
        weatherCacheDataSource.saveWeatherToCache(weather)
        return weather
    }

    suspend fun getWeatherFromAPI(latitude: Double, longitude: Double): Weather{
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

    suspend fun getWeatherFromDB(city: City): Weather{
        lateinit var weatherList: Weather
        try {
            weatherList = weatherLocalDataSource.getWeatherFromDB(city.id)
        }catch (exception: Exception){
            Log.i(TAG, exception.message.toString())
        }
        if (weatherList == null){
            weatherList = getWeatherFromAPI(city.latitude, city.longitude)
            weatherLocalDataSource.saveWeatherToDB(weatherList)
        }
        return weatherList
    }

    suspend fun getWeatherFromCache(city: City): Weather{
        lateinit var weatherList: Weather
        try {
            weatherList = weatherCacheDataSource.getWeatherFromCache()
        }catch (exception: Exception){
            Log.i(TAG, exception.message.toString())
        }
        if (weatherList == null){
            weatherList= getWeatherFromDB(city)
            weatherCacheDataSource.saveWeatherToCache(weatherList)
        }
        return weatherList
    }
}
