package co.javimay.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.domain.usecase.city.GetCityUseCase
import co.javimay.weatherapp.domain.usecase.city.SaveCityUseCase
import co.javimay.weatherapp.domain.usecase.city.UpdateCityUseCase

class CityViewModel(
    private val getCityUseCase: GetCityUseCase,
    private val updateCityUseCase: UpdateCityUseCase,
    private val saveCityUseCase: SaveCityUseCase
): ViewModel() {
    fun getCities() = liveData{
        val cityList: List<City>? = getCityUseCase.execute()
        emit(cityList)
    }

    fun updateCities() = liveData{
        val movieList: List<City>? = updateCityUseCase.execute()
        emit(movieList)
    }

    fun saveCities(city: City) = liveData{
        val cityList: City? = saveCityUseCase.execute()
        emit(cityList)

    }
}