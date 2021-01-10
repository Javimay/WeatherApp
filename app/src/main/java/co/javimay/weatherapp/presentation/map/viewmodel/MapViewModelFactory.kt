package co.javimay.weatherapp.presentation.map.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.javimay.weatherapp.domain.usecase.city.SaveCityUseCase
import javax.inject.Inject

class MapViewModelFactory(
    private val saveCityUseCase: SaveCityUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MapViewModel(saveCityUseCase) as T
}