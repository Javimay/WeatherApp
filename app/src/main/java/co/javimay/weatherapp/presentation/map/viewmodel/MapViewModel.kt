package co.javimay.weatherapp.presentation.map.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.javimay.weatherapp.domain.usecase.city.SaveCityUseCase
import co.javimay.weatherapp.mapper.CityMapper
import co.javimay.weatherapp.presentation.city.model.City

class MapViewModel(
    private val saveCityUseCase: SaveCityUseCase
):ViewModel() {
    fun saveCities(city: City) = liveData{

        CityMapper().mapToRemote(city)?.let { saveCityUseCase.execute(it) }
        emit(true)
    }
}