package co.javimay.weatherapp.di.city

import co.javimay.weatherapp.domain.usecase.city.GetCityUseCase
import co.javimay.weatherapp.domain.usecase.city.DeleteCityUseCase
import co.javimay.weatherapp.presentation.home.viewmodel.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CityModule {
    @CityScope
    @Provides
    fun provideCityViewModelFactory(
        getCityUseCase: GetCityUseCase,
        deleteCityUseCase: DeleteCityUseCase
        ): HomeViewModelFactory
            = HomeViewModelFactory(getCityUseCase, deleteCityUseCase)
}