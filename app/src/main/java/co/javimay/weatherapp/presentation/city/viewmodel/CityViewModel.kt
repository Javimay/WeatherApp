package co.javimay.weatherapp.presentation.city.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.domain.usecase.weather.GetWeatherUseCase
import co.javimay.weatherapp.mapper.CityMapper
import co.javimay.weatherapp.presentation.city.model.City

class CityViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {
    fun getWeather(city: City) = liveData{
        val weatherList: Weather? = CityMapper().mapToRemote(city)?.let {
            getWeatherUseCase.execute(it)
        }
        emit(weatherList)
    }
}