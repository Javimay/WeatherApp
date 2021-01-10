package co.javimay.weatherapp.di.map

import co.javimay.weatherapp.domain.usecase.city.SaveCityUseCase
import co.javimay.weatherapp.presentation.map.viewmodel.MapViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MapModule {
    @MapScope
    @Provides
    fun providMapViewModelFactory(
        saveCityUseCase: SaveCityUseCase
    ): MapViewModelFactory = MapViewModelFactory(saveCityUseCase)
}