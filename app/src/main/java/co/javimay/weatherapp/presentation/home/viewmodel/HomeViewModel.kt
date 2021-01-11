package co.javimay.weatherapp.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.javimay.weatherapp.domain.usecase.city.GetCityUseCase
import co.javimay.weatherapp.domain.usecase.city.DeleteCityUseCase
import co.javimay.weatherapp.mapper.CityMapper
import co.javimay.weatherapp.presentation.city.model.City

class HomeViewModel(
    private val getCityUseCase: GetCityUseCase,
    private val deleteCityUseCase: DeleteCityUseCase,
): ViewModel() {
    fun getCities() = liveData{
        val cityList: List<City>? = getCityUseCase.execute()?.map{ CityMapper().mapFromRemote(it)!! }
        emit(cityList)
    }

    fun deleteCities() = liveData{
        val city = deleteCityUseCase.execute()
        emit(city)
    }

    fun deleteCity(city: City) = liveData{
        CityMapper().mapToRemote(city)?.let { deleteCityUseCase.execute(it) }
        emit(true)
    }
}