package co.javimay.weatherapp.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.javimay.weatherapp.data.db.model.City
import co.javimay.weatherapp.domain.usecase.city.GetCityUseCase
import co.javimay.weatherapp.domain.usecase.city.DeleteCityUseCase
import co.javimay.weatherapp.domain.usecase.weather.GetWeatherUseCase

class HomeViewModel(
    private val getCityUseCase: GetCityUseCase,
    private val deleteCityUseCase: DeleteCityUseCase,
): ViewModel() {
    fun getCities() = liveData{
        val cityList: List<City>? = getCityUseCase.execute()
        emit(cityList)
    }

    fun deleteCities() = liveData{
        val city = deleteCityUseCase.execute()
        emit(city)
    }
}