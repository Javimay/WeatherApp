package co.javimay.weatherapp.presentation.city.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.usecase.weather.GetWeatherUseCase

class CityViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {
    fun getWeather(city: City) = liveData{
        val weatherList: Weather? = getWeatherUseCase.execute(city)
        emit(weatherList)
    }
}