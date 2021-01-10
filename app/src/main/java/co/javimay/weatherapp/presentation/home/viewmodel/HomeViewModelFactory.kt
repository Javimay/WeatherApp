package co.javimay.weatherapp.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.javimay.weatherapp.domain.usecase.city.GetCityUseCase
import co.javimay.weatherapp.domain.usecase.city.DeleteCityUseCase

class HomeViewModelFactory(
    private val getCityUseCase: GetCityUseCase,
    private val deleteCityUseCase: DeleteCityUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        HomeViewModel(getCityUseCase, deleteCityUseCase) as T
}