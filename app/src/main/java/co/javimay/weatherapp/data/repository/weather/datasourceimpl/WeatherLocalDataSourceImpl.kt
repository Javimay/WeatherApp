package co.javimay.weatherapp.data.repository.weather.datasourceimpl

import co.javimay.weatherapp.data.db.WeatherDao
import co.javimay.weatherapp.data.model.Weather
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherLocalDataSourceImpl(private val weatherDao: WeatherDao):WeatherLocalDataSource {
    override suspend fun getWeatherFromDB(cityId: Int): Weather =
        weatherDao.getWeather(cityId)

    override suspend fun saveWeatherToDB(weather: Weather) {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDao.saveWeather(weather)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDao.deleteAllWeather()
        }
    }
}