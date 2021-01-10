package co.javimay.weatherapp.presentation.city.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.javimay.weatherapp.domain.usecase.weather.GetWeatherUseCase

class CityViewModelFactory(
    private val getWeatherUseCase: GetWeatherUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        CityViewModel(getWeatherUseCase) as T
}